package com.softtek.academy.jstl.domain.model;

public class Status {
	
	private Long id;
	private String description;
	private String type;

	
	public Status(Long id, String description, String type) {
		this.id = id;
		this.description = description;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Status [id=" + id + ", description=" + description + ", type=" + type + "]";
	}	
}
