package com.softtek.academy.springcore.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.springcore.example.domain.PrototypeObject;
import com.softtek.academy.springcore.example.domain.SingletonObject;

/**
 * Spring context creation and bean definition in
 * Singleton and Prototype scopes. 
 *
 */
public class Example1 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/softtek/academy/springcore/example/example1.xml");
		
		// With prototype definitions, you get a different instance each time a bean is requested out of the context
		PrototypeObject prototypeObj = (PrototypeObject)applicationContext.getBean(PrototypeObject.class);
		System.out.println(prototypeObj);
		prototypeObj = (PrototypeObject)applicationContext.getBean(PrototypeObject.class);
		System.out.println(prototypeObj);
		// With singleton definitions, the same instance is returned each time a bean is requested out of the context
		SingletonObject singletonObj = (SingletonObject)applicationContext.getBean(SingletonObject.class);
		System.out.println(singletonObj);
		singletonObj = (SingletonObject)applicationContext.getBean(SingletonObject.class);
		System.out.println(singletonObj);
	}

}
