package com.jeffknecht.rbtest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffknecht.rbtest.service.Item;
import com.jeffknecht.rbtest.service.ItemService;

@RestController
public class LanguageController {
	
	@Autowired ItemService service;
	
	@RequestMapping("/")
	public Iterable<Item> index(Locale locale) {
		System.err.println(locale);
		return service.findAll(locale);
	}

}
