package com.softtek.java.academy.basics.enums;

public enum WeekEnum {

	MONDAY(1, "Lunes"),
	TUESDAY(2, "Martes"),
	WEDNESDAY(3, "Miercoles"),
	THURSDAY(4, "Jueves"),
	FRIDAY(5, "Viernes"),
	SATURDAY(6, "Sabado"),
	SUNDAY(7, "Domingo");

	private int num;
	private String spanishName;

	private WeekEnum(final int num, final String spanishName) {

		this.num = num;
		this.spanishName = spanishName;
	}

	/**
	 * @return the num
	 */
	public int getNum() {

		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(final int num) {

		this.num = num;
	}

	/**
	 * @return the spanishName
	 */
	public String getSpanishName() {

		return spanishName;
	}

	/**
	 * @param spanishName the spanishName to set
	 */
	public void setSpanishName(final String spanishName) {

		this.spanishName = spanishName;
	}

}
