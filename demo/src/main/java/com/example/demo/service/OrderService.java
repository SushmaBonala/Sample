package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Exception.NoOrdersFoundException;
import com.example.demo.Exception.OutOfStockException;
import com.example.demo.entity.Order;

public interface OrderService {

	public List<Order> getAllOrders() throws NoOrdersFoundException;
	public Order addOrder(Order addOrder) throws OutOfStockException, ItemNotFoundException;
}
