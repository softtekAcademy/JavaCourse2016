package com.softtek.academy.springcore.example.repository;

import com.softtek.academy.springcore.example.domain.Rule;

public interface RuleRepository {
	
	Rule getRuleByItemId(int itemId);

}
