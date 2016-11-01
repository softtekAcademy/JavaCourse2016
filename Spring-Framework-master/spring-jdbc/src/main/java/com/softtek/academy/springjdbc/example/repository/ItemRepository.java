package com.softtek.academy.springjdbc.example.repository;

import java.util.List;

import com.softtek.academy.springjdbc.example.domain.Item;

public interface ItemRepository {
	
	String getItemDescription(Integer id);
	Double getItemValue(Integer id);
	Item getItemById(Integer id);
	List<Item> getAllItems();
	List<Item> getAllItems2();
	void insertItem(Item item);
	void updateItem(Item istem);
	void removeItem(Integer itemId);
}
