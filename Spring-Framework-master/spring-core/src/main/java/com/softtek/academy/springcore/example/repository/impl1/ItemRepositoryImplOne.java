package com.softtek.academy.springcore.example.repository.impl1;

import org.springframework.stereotype.Repository;

import com.softtek.academy.springcore.example.domain.Item;
import com.softtek.academy.springcore.example.repository.ItemRepository;

@Repository
public class ItemRepositoryImplOne implements ItemRepository {

	public Item getItem(int itemId) {
		return new Item("Item created by implementation One");
	}

}
