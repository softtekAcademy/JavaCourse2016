package com.softtek.academy.springcore.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.academy.springcore.example.domain.Item;
import com.softtek.academy.springcore.example.domain.Rule;
import com.softtek.academy.springcore.example.repository.ItemRepository;
import com.softtek.academy.springcore.example.repository.RuleRepository;

@Service
public class BlockRuleServiceImpl implements BlockRuleService {
	
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private RuleRepository ruleRepository;

	public Item getRuledItem(final int itemId) {
		Item item = itemRepository.getItem(itemId);
		Rule rule = ruleRepository.getRuleByItemId(itemId);
		item.setRule(rule);
		return item;
	}

}
