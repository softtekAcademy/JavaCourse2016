package com.softtek.academy.springcore.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.springcore.example.service.ItemService;

/**
 * By coding to interfaces, Spring can be really helpful at assembling
 * (or injecting) different implementations with changing the configuration
 * only.
 */
public class Example2 {

	public static void main(String[] args) {
		// We can assemble different implementations by changing configuration without requiring code changes.
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("/com/softtek/academy/springcore/example/example2_1.xml");
		
		ItemService itemService = (ItemService)applicationContext1.getBean(ItemService.class);
		System.out.println(itemService.getItem(1).getMessage());
		
		ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("/com/softtek/academy/springcore/example/example2_2.xml");
		
		itemService = (ItemService)applicationContext2.getBean(ItemService.class);
		System.out.println(itemService.getItem(1).getMessage());
	}

}
