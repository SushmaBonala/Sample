package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.*;
import org.springframework.util.StringUtils;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	
	public ItemRepository itemRepo;
	
	@Autowired
	@Qualifier("itemRepo")
	public void setItemService(ItemRepository itemRepo){
	    this.itemRepo=itemRepo;
	}
	
	public Item getItembyId(String id) throws ItemNotFoundException {
		Item itemById = new Item();
		Optional<Item> result = itemRepo.findById(id);
		if(result.isPresent()) {
			itemById.setId(StringUtils.hasText(result.get().getId())?result.get().getId():"");
			itemById.setName(StringUtils.hasText(result.get().getName())?result.get().getName():"");
			itemById.setQuantity(result.get().getQuantity());
		}
		else {
			throw new ItemNotFoundException();
		}
		return itemById;
	}
	
	public Item getItembyName(String name) throws ItemNotFoundException {
		Item item = new Item();
		Optional<Item> itemResult = itemRepo.findByName(name);
		if(itemResult.isPresent()) {
			item.setId(StringUtils.hasText(itemResult.get().getId())?itemResult.get().getId() : "");
			item.setName(StringUtils.hasText(itemResult.get().getName())?itemResult.get().getName() : "");
			item.setQuantity(itemResult.get().getQuantity());
			}
		else {
			throw new ItemNotFoundException();
		}
		return item;
	}

	public List<Item> getAllItems() throws ItemNotFoundException {
		ArrayList<Item> items = new ArrayList<Item>();
		itemRepo.findAll().forEach(items :: add);
		if(!(items.size()>0)) {
			throw new ItemNotFoundException();
		}
		return items;
	}
	
	public void addItem(Item item) {
		itemRepo.save(item);
	}

	public void deleteItem(String id) throws ItemNotFoundException {
		Item result = getItembyId(id);
		itemRepo.delete(result);
	}
	
}
