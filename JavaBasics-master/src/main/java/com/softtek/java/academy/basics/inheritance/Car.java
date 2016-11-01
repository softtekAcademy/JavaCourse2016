package com.softtek.java.academy.basics.inheritance;

public class Car extends Transport {

	public Car() {

		anotherAttr = "";
		ruta = "";
		color = "";
		go();
		curiosity("");
	}

	@Override
	public void go() {

		System.out.println("...going on the street.....");
	}

	void curiosity(final int something) {

	}

}
