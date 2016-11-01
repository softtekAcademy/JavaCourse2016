package com.softtek.java.academy.basics.operators;

import java.util.Scanner;


public class CalculatorExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.print("Type a number: ");
		int num1 = s.nextInt();
		System.out.print("Type a second number: ");
		int num2 = s.nextInt();
		
		Calculator c = new Calculator();
		
		System.out.println("The sum is: "+c.getSum(num1, num2));
		System.out.println("Substraction is: "+c.getRest(num1, num2));
		System.out.println("The multiplication is: "+c.getMult(num1, num2));
		System.out.println("The division is: "+c.getDiv(num1, num2));
		System.out.println("The module is: "+c.getMod(num1, num2));
	}

}
