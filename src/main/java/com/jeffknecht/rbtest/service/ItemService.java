package com.jeffknecht.rbtest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffknecht.rbtest.DatabaseBundleControl;
import com.jeffknecht.rbtest.db.LanguagePairRepository;

@Service
public class ItemService {

	@Autowired LanguagePairRepository repo;

	public Collection<Item> findAll(Locale locale) {
		
		ResourceBundle rb = ResourceBundle.getBundle("item", locale, new DatabaseBundleControl(repo)); 
		
		ArrayList<Item> items = new ArrayList<>();
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			items.add(new Item(key, (String) rb.getObject(key)));
		}
		return items;
	}
	
}
