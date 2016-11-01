package com.softtek.java.academy.basics.conditionals;

import java.util.Scanner;


public class PositiveNumberExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.print("Type a number: ");
		int num = s.nextInt();
		
		PositiveNumber p = new PositiveNumber();
		
		if(p.isPositiveNumber(num)){
			System.out.println(num + " is a possitive number");
		}else{
			System.out.println(num + " is a negative number");
		}
	}

}
