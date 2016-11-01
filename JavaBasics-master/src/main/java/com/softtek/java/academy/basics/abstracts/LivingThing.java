package com.softtek.java.academy.basics.abstracts;

public abstract class LivingThing {

	private String name;

	// public LivingThing() {
	//
	// }

	public LivingThing(final String name) {

		this.name = name;
	}

	public void breath() {

		System.out.println("Living Thing breathing...");
	}

	public void eat() {

		System.out.println("Living Thing eating...");
	}

	/**
	 * Abstract method walk()
	 * We want this method to be implemented by subclasses of
	 * LivingThing
	 */
	public abstract void walk();

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}
}
