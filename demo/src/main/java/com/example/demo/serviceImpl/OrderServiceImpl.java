package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Exception.NoOrdersFoundException;
import com.example.demo.Exception.OutOfStockException;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	public OrderRepository orderRepo;
	
	@Autowired
	@Qualifier("orderRepo")
	public void setOrderService(OrderRepository orderRepo){
	    this.orderRepo=orderRepo;
	}
	
	@Autowired
	@Qualifier("itemService")
	public ItemService itemService;
	
	public List<Order> getAllOrders() throws NoOrdersFoundException {
		ArrayList<Order> orders = new ArrayList<Order>();
		orderRepo.findAll().forEach(orders :: add);
		if(!(orders.size()>0)) {
			throw new NoOrdersFoundException();
		}
		return orders;
	}
	
	public Order addOrder(Order addOrder) throws OutOfStockException, ItemNotFoundException{
		Item item = itemService.getItembyName(addOrder.getItemName());
		if(addOrder.getQuantity()>item.getQuantity()) {
			throw new OutOfStockException();
		}
		else {
			orderRepo.save(addOrder);
			item.setQuantity(item.getQuantity()-addOrder.getQuantity());
			itemService.addItem(item);
		}
		return addOrder;
	}
	
}
