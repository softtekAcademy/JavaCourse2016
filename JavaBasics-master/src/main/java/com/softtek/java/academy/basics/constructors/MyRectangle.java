/**
 * 
 */
package com.softtek.java.academy.basics.constructors;

/**
 * @author diego.olvera
 *
 */
public class MyRectangle {

	int x, y; // Atributes or Variables

	public MyRectangle() {

		x = 10;
		y = 20;

		System.out.println("Inside constructor...");
	}

	public static void main(final String[] args) {

		final MyRectangle r = new MyRectangle();
		System.out.println(r.x);
		System.out.println(r.y);
	}
}
