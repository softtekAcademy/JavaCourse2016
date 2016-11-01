package com.softtek.java.academy.basics.enums;

import java.io.Serializable;

public class MonthsMain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	void printMonth(final String month) {

		System.out.println("Month: " + month);
	}

	void printMonth(final MonthsEnum me) {

		System.out.println("Month: " + me.name());
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final MonthsMain mm = new MonthsMain();

		mm.printMonth(MonthsStaticsUtil.JUL);

		mm.printMonth(MonthsEnum.NOVEMBER);
	}

}
