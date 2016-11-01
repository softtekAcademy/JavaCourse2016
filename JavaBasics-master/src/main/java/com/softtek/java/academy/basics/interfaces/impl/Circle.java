package com.softtek.java.academy.basics.interfaces.impl;

import com.softtek.java.academy.basics.interfaces.Figurable;

public class Circle implements Figurable {

	private double r;

	@Override
	public double getArea() {

		return Math.PI * r * r;
	}

	/**
	 * @return the r
	 */
	public double getR() {

		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(final double r) {

		this.r = r;
	}

}
