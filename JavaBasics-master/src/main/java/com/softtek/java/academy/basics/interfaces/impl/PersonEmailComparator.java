package com.softtek.java.academy.basics.interfaces.impl;

import java.util.Comparator;

public class PersonEmailComparator implements Comparator<Person> {

	@Override
	public int compare(final Person p1, final Person p2) {

		// TODO Auto-generated method stub
		return p1.getEmail().compareTo(p2.getEmail());
	}

}
