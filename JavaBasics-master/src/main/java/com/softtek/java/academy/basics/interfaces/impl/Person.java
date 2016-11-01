package com.softtek.java.academy.basics.interfaces.impl;

public class Person implements Comparable<Person> {

	private String name;

	private Integer age;

	private String email;

	public Person(final Integer age) {

		this.age = age;
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
	public void setName(final String name) {

		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {

		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(final Integer age) {

		this.age = age;
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
	public void setEmail(final String email) {

		this.email = email;
	}

	@Override
	public int compareTo(final Person person) {

		return this.age - person.age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Person [name=" + name + ", age=" + age + ", email=" + email + "]";
	}

}
