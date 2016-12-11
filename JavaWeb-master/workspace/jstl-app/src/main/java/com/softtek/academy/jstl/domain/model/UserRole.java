package com.softtek.academy.jstl.domain.model;

public class UserRole {
	
	private String id;
	private String description;
	
	
	/**
	 * @param id
	 * @param description
	 */
	public UserRole(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", description=" + description + "]";
	}
}
