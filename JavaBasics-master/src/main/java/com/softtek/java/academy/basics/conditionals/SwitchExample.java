package com.softtek.java.academy.basics.conditionals;

import java.util.Scanner;


public class SwitchExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("TYPE: ");
		int value = new Scanner(System.in).nextInt();
		
		switch(value){
			case 15:
			case 16:
			case 17:
				System.out.println("Teen");
				
			case 18:
				System.out.println("Young");
				
			default:
				System.out.println("AnyThing");
				
			case 25:
				System.out.println("Adult");
				break;
			
		}

	}

}
