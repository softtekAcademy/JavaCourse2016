package com.softtek.java.academy.basics.abstracts;

public class Human extends LivingThing {

	public Human() {

		super("");

	}

	@Override
	public void walk() {

		System.out.println(getName() + " is walking....");
	}

}
