package com.softtek.java.academy.basics.interfaces.impl;

import com.softtek.java.academy.basics.interfaces.Figurable;

public class Triangle implements Figurable {

	private double b;
	private double h;

	@Override
	public double getArea() {

		return (b * h) / 2;
	}

	public double getB() {

		return b;
	}

	public void setB(final double b) {

		this.b = b;
	}

	public double getH() {

		return h;
	}

	public void setH(final double h) {

		this.h = h;
	}
}
