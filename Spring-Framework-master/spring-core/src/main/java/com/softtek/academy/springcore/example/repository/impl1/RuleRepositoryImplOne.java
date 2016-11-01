package com.softtek.academy.springcore.example.repository.impl1;

import org.springframework.stereotype.Repository;

import com.softtek.academy.springcore.example.domain.Rule;
import com.softtek.academy.springcore.example.repository.RuleRepository;

@Repository
public class RuleRepositoryImplOne implements RuleRepository {

	public Rule getRuleByItemId(int itemId) {
		return new Rule();
	}

}
