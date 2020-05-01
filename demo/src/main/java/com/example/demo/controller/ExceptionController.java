package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Exception.NoOrdersFoundException;
import com.example.demo.Exception.OutOfStockException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity outOfStock() {
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("message", "Out of Stock please try again after some time");
		ResponseEntity response = new ResponseEntity(body,HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity itemNotFound() {
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("message", "Item not found");
			ResponseEntity response = new ResponseEntity(body,HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(NoOrdersFoundException.class)
	public ResponseEntity OrderNotFound() {
		 Map<String, Object> body = new LinkedHashMap<>();
		 body.put("message", "No orders found");
		ResponseEntity response = new ResponseEntity(body,HttpStatus.NOT_FOUND);
		return response;
	}
	
}
