package com.softtek.academy.contact.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 'Person' representation class.
 * 
 * @author David.Hernandez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

	/* ------- Instance members ------- */
	
	private Long id;
	private String name;
	private String alias;
	private String phoneNumber;
	private String email;
	private Date birthdate;
	private String imagePath;
	
	
	/* ------- Getters & Setters ------- */
	/**
	 * @return the internalId
	 */
	public Long getId() {
	
		return id;
	}
	
	/**
	 * @param internalId the internalId to set
	 */
	public void setId(Long id) {
	
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * @return the alias
	 */
	public String getAlias() {
	
		return alias;
	}
	
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
	
		this.alias = alias;
	}
	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
	
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
	
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
	
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
	
		this.email = email;
	}
	
	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
	
		return birthdate;
	}
	
	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
	
		this.birthdate = birthdate;
	}
	
	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
	
		return imagePath;
	}
	
	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
	
		this.imagePath = imagePath;
	}

	/* ------- Constructor ------- */
	
	/**
	 * Default constructor.
	 */
	public Person(){}
	
	
	/**
	 * Custom constructor.
	 */
	public Person(final Long id, final String name, final String alias){
		this.id = id;
		this.name = name;
		this.alias = alias;
	}
	
	/* ------- Override methods ------- */

	/* Gets 'Person' in string representation.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Person [ID=" + id + ", name=" + name + ", alias=" + alias + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", birthdate=" + birthdate + ", imagePath=" + imagePath + "]";
	}
}
