package com.jeffknecht.rbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeffknecht.rbtest.db.LanguagePair;
import com.jeffknecht.rbtest.db.LanguagePairRepository;

@RestController
public class LanguageController {
	
	@Autowired LanguagePairRepository repo;
	
	@RequestMapping("/")
	public Iterable<LanguagePair> index() {
		return repo.findAll();
	}

}
