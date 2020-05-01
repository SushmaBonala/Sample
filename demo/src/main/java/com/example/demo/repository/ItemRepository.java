package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;
@Repository("itemRepo")
public interface ItemRepository extends CrudRepository<Item,String>{

	public  Optional<Item> findByName(String name);
}
