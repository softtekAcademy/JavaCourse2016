package com.softtek.java.academy.basics.enums;

public class WeekMain {

	void printMonth(final WeekEnum we) {

		System.out.println("Week day: " + we.name());
		System.out.println("num: " + we.getNum());
		System.out.println("spanish name: " + we.getSpanishName());
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final WeekMain wm = new WeekMain();

		wm.printMonth(WeekEnum.SATURDAY);
	}

}
