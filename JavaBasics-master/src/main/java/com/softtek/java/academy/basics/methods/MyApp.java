/**
 * 
 */
package com.softtek.java.academy.basics.methods;

/**
 * @author diego.olvera
 *
 */
public class MyApp {

	void printGreeting() {

		System.out.println("Hello!");
	}

	public static void main(final String[] args) {

		final MyApp app = new MyApp();

		app.printGreeting();
	}
}
