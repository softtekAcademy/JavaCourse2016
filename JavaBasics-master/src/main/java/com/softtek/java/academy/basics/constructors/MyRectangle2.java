/**
 * 
 */
package com.softtek.java.academy.basics.constructors;

/**
 * @author diego.olvera
 *
 */
public class MyRectangle2 {

	int x, y;

	public MyRectangle2(final int a, final int b) {

		x = a;
		y = b;
		System.out.println("Inside constructor with parameters");
	}

	public static void main(final String[] args) {

		final MyRectangle2 r = new MyRectangle2(50, 10);
		System.out.println(r.x);
		System.out.println(r.y);
	}
}
