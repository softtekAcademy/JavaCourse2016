package com.softtek.java.academy.basics.statics;

import com.softtek.java.academy.basics.interfaces.impl.Person;

public class StaticClass {

	static Integer x = 12; // Class attribute

	Integer y = 10; // Instance attribute

	final int CONSTANT = 10;

	final Person per = new Person(30);

	static void staticMethod() {

		StaticClass.x++;
		System.out.println("This is a static method.....you don't need to create objects!");
	}

	final void anotherMethod() {

		y++;
		StaticClass.x++;
		System.out.println("Non-static method.....you need create objects to use me....");
		per.setAge(34);

	}
}
