package com.softtek.academy.springcore.example.repository.impl2;

import org.springframework.stereotype.Repository;

import com.softtek.academy.springcore.example.domain.Item;
import com.softtek.academy.springcore.example.repository.ItemRepository;

@Repository
public class ItemRepositoryImplTwo implements ItemRepository {

	public Item getItem(int itemId) {
		return new Item("Item created by Implemenation Two");
	}

}
