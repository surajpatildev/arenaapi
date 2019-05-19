package com.arenaapi.service;


import org.springframework.stereotype.Service;

@Service("test")
public class Test {
	
	private String name;
	 
	public void setName(String name) {
		this.name = name;
	}
 
	public String sayHello() {
		return  name;
	}
}
