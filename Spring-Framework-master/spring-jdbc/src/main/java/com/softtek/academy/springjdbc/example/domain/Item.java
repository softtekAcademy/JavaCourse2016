package com.softtek.academy.springjdbc.example.domain;

public class Item {
	private Integer id;
	private String description;
	private Double value;
	
	public Item(final Integer id, final String description, final Double value) {
		setId(id);
		setDescription(description);
		setValue(value);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	public String toString() {
		return super.toString() + "[ID=" + getId() + ", Description=" + 
				getDescription() + ", Value=" + getValue();
	}
}
