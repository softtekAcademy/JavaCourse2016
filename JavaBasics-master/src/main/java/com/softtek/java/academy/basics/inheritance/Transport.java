package com.softtek.java.academy.basics.inheritance;

public class Transport {

	String color;

	private int year;

	protected String anotherAttr;

	public String ruta;

	public void go() {

		System.out.println("....going.....");
	}

	protected void curiosity(final String something) {

		System.out.println("I'm a final method, you Can't override me....");
	}
}
