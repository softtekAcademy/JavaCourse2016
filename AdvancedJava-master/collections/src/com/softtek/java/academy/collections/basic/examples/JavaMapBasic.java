/**
 * 
 */
package com.softtek.java.academy.collections.basic.examples;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alejandro
 *
 */
public class JavaMapBasic {
	public static void main(String[] args) {
	      Map namesMap = new HashMap(); 
	      namesMap.put("Zara", "8");
		  namesMap.put("Mahnaz", "31");
		  namesMap.put("Ayan", "12");
		  namesMap.put("Daisy", "14");
		  System.out.println();
		  System.out.println(" Map Elements");
		  System.out.print("\t" + namesMap);
	}
}
