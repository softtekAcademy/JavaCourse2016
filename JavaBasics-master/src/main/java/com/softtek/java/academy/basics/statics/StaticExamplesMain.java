package com.softtek.java.academy.basics.statics;

public class StaticExamplesMain {

	public static void main(final String[] args) {

		StaticClass.staticMethod();

		final StaticClass s = new StaticClass();

		final StaticClass c = new StaticClass();

		s.anotherMethod();
		c.anotherMethod();

		System.out.println(StaticClass.x);
		System.out.println(s.y);
		System.out.println(c.y);
	}

}
