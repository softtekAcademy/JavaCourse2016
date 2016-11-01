package com.softtek.java.academy.basics.abstracts;

import java.util.Comparator;
import java.util.concurrent.ThreadFactory;

import com.softtek.java.academy.basics.interfaces.impl.Person;

public abstract class AnotherAbstractClass implements Comparable<Person>, Comparator<String>, ThreadFactory {

	public abstract void method();

	public abstract void method2();

	public abstract void method3();

	public abstract void method4();
}
