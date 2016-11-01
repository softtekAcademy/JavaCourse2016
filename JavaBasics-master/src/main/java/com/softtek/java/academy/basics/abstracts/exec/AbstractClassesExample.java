package com.softtek.java.academy.basics.abstracts.exec;

import com.softtek.java.academy.basics.abstracts.Human;
import com.softtek.java.academy.basics.abstracts.LivingThing;

public class AbstractClassesExample {

	public static void main(final String[] args) {

		final LivingThing human = new Human();

		human.setName("Diego");

		human.walk();
	}
}
