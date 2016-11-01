/**
 * 
 */
package com.softtek.java.academy.basics.constructors;

/**
 * @author Koitoer
 *
 */
class CarClass
{

	public int speedLimit()
	{

		return 100;
	}
}

class NewCar extends CarClass
{

	@Override
	public int speedLimit()
	{

		return 150;
	}
}