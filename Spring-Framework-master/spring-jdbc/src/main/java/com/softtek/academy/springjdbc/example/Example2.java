package com.softtek.academy.springjdbc.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.springjdbc.example.domain.Item;
import com.softtek.academy.springjdbc.example.repository.ItemRepository;


/**
 * CRUD operations using NamedParameterJDBCTemplate over an in-memory database.
 */
public class Example2 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/softtek/academy/springjdbc/example/example2.xml");
		
		ItemRepository repo = (ItemRepository)applicationContext.getBean(ItemRepository.class);
		System.out.println(repo.getItemDescription(1));
		System.out.println(repo.getItemValue(1));
		System.out.println(repo.getItemById(1));
		System.out.println(repo.getAllItems());
		Item newItem = new Item(10, "Item 10", 95.0);
		repo.insertItem(newItem);
		System.out.println(repo.getAllItems());
		newItem.setDescription("New Description Item 10");
		newItem.setValue(94.3);
		repo.updateItem(newItem);
		System.out.println(repo.getAllItems());
		repo.removeItem(10);
		System.out.println(repo.getAllItems());
		System.out.println(repo.getAllItems2());
	}

}
