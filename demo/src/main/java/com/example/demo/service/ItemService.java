package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.entity.Item;

public interface ItemService {

	public Item getItembyId(String id) throws ItemNotFoundException;
	public Item getItembyName(String name) throws ItemNotFoundException;
	public List<Item> getAllItems() throws ItemNotFoundException;
	public void addItem(Item item);
	public void deleteItem(String id) throws ItemNotFoundException;
}
