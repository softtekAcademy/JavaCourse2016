package com.softtek.java.academy.basics.interfaces.impl.exec;

import java.util.Scanner;

import com.softtek.java.academy.basics.interfaces.Figurable;
import com.softtek.java.academy.basics.interfaces.impl.Circle;
import com.softtek.java.academy.basics.interfaces.impl.Triangle;

public class FiguresMain {

	public double calculateArea(Figurable f) {
		return f.getArea();
	}

	public static void main(final String[] args) {

		final Scanner s = new Scanner(System.in);
		final Circle c = new Circle();
		c.setR(6);
		
		Triangle t = new Triangle();
		t.setB(8);
		t.setH(6);

		FiguresMain fm = new FiguresMain();
		System.out.println("Area Circle: "+fm.calculateArea(c));
		
		System.out.println("Area Triangle: "+fm.calculateArea(t));
		
	}
}
