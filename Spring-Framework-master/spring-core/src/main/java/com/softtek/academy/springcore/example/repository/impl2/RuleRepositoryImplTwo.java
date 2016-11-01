package com.softtek.academy.springcore.example.repository.impl2;

import org.springframework.stereotype.Repository;

import com.softtek.academy.springcore.example.domain.Rule;
import com.softtek.academy.springcore.example.repository.RuleRepository;

@Repository
public class RuleRepositoryImplTwo implements RuleRepository {

	public Rule getRuleByItemId(int itemId) {
		return new Rule();
	}

}
