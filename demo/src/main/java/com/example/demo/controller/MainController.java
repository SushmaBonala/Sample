package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Exception.NoOrdersFoundException;
import com.example.demo.Exception.OutOfStockException;
import com.example.demo.entity.Item;
import com.example.demo.entity.Order;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping("/app")
public class MainController {

	
	public ItemService itemService;
	
	@Autowired
	@Qualifier("itemService")
	public void setItemService(ItemService itemService){
	    this.itemService=itemService;
	}
	
	public OrderService orderService;
	
	@Autowired
	@Qualifier("orderService")
	public void setOrderService(OrderService orderService){
	    this.orderService=orderService;
	}
	
	@GetMapping("/getAllItems")
	public ResponseEntity getAllItems() throws ItemNotFoundException {
		ResponseEntity response = new ResponseEntity(itemService.getAllItems(),HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/getItemById")
	public ResponseEntity getItemById(@RequestParam("id") String id) throws ItemNotFoundException {
		ResponseEntity response = new ResponseEntity(itemService.getItembyId(id),HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addItem")
	public ResponseEntity addItem(@RequestBody Item addItem) {
		itemService.addItem(addItem);
		ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity updateItem(@RequestBody Item updateItem) {
		itemService.addItem(updateItem);
		ResponseEntity response =  new ResponseEntity(HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/deleteItem")
	public ResponseEntity deleteItem(@RequestParam("id")String id) throws ItemNotFoundException {
		itemService.deleteItem(id);
		ResponseEntity response =  new ResponseEntity(HttpStatus.OK);
		return response;
	}
	

	@GetMapping("/getAllOrders")
	public ResponseEntity getAllOrders() throws NoOrdersFoundException {
		ResponseEntity response =  new ResponseEntity(orderService.getAllOrders(),HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity addItem(@Valid @RequestBody Order addOrder) throws OutOfStockException, ItemNotFoundException {
		orderService.addOrder(addOrder);
		ResponseEntity response =  new ResponseEntity(HttpStatus.OK);
		return response;
	}
}
