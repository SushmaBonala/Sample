package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
@Entity
@Table(name = "order_table")
public class Order {
	@Id
	public String id;
	public String itemName;
	@Email(message="Enter Valid email")
	public String email;
	public int quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
