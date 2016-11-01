package com.softtek.academy.springcore.example.domain;

public class Item {
	
	private String message;
	private Rule rule;
	
	public Item(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
