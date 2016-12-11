package com.softtek.academy.jsp.domain.model;

import com.google.common.base.Objects;

public class State {
	
	private Long id;
	private String description;
	
	
	public State(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("description", description).toString();
	}
	
}
