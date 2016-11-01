package com.softtek.academy.springcore.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.springcore.example.domain.Item;
import com.softtek.academy.springcore.example.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item getItem(int itemId) {
		return itemRepository.getItem(itemId);
	}

}
