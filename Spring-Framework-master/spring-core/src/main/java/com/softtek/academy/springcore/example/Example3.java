package com.softtek.academy.springcore.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softtek.academy.springcore.example.domain.ConfigurableBean;

/**
 * Value injection to defined beans from property file 
 *
 */
public class Example3 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/softtek/academy/springcore/example/example3.xml");
		
		ConfigurableBean bean = (ConfigurableBean)applicationContext.getBean(ConfigurableBean.class);
		System.out.println(bean.getParameter1());
		System.out.println(bean.getParameter2());
	}

}
