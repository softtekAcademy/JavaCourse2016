package com.softtek.academy.springcore.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableBean {

	@Value("${example.parameter1}")
	private String parameter1;
	@Value("${example.parameter2}")
	private String parameter2;
	
	public String getParameter1() {
		return parameter1;
	}
	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}
	public String getParameter2() {
		return parameter2;
	}
	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}
}
