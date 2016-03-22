package com.jeffknecht.rbtest.service;

public class Item {
	private String code;
	private String description;
	
	public Item(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	
}
