package com.softtek.java.academy.basics.arrays;

public class PrintArrays {

	public String printArray(final int[] arr) {

		final StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (final int elem : arr) {
			sb.append(elem + ",");
		}

		final int i = sb.lastIndexOf(",");
		sb.deleteCharAt(i);
		sb.append("]");

		return sb.toString();
	}

	public String printBiArray(final int[][] arr) {

		final StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (final int[] elem : arr) {
			for (final int num : elem) {
				sb.append(num + ",");
			}
		}

		final int i = sb.lastIndexOf(",");
		sb.deleteCharAt(i);
		sb.append("]");

		return sb.toString();
	}

}
