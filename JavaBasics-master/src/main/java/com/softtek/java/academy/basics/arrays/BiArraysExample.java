package com.softtek.java.academy.basics.arrays;

public class BiArraysExample {

	public static void main(final String[] args) {

		final int[][] biArr = { { 1, 2, 3, 4, 4 }, { 12, 3 }, { 34, 5, 7, 8 } };

		PrintArrays pa = new PrintArrays();
		
		System.out.println(pa.printBiArray(biArr));
	}
}
