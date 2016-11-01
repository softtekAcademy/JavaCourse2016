package com.softtek.academy.springcore.example.repository;

import com.softtek.academy.springcore.example.domain.Item;

public interface ItemRepository {
	Item getItem(final int itemId);
}
