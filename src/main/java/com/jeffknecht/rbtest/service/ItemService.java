package com.jeffknecht.rbtest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffknecht.rbtest.DatabaseBundleControl;
import com.jeffknecht.rbtest.db.LanguagePair;
import com.jeffknecht.rbtest.db.LanguagePairRepository;

@Service
public class ItemService {

	@Autowired LanguagePairRepository repo;

	public Collection<Item> findAll(Locale locale) {
		
		DatabaseBundleControl control = new DatabaseBundleControl(repo);
		ResourceBundle rb = ResourceBundle.getBundle("item", locale, control);
		
		ArrayList<Item> items = new ArrayList<>();
		Enumeration<String> keys = rb.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			items.add(new Item(key, (String) rb.getObject(key)));
		}
		return items;
	}
	
	public void updateItems() {
		{
			LanguagePair p = new LanguagePair();
			p.setBundle("item");
			p.setKey("tooth");
			p.setValue("Toothpaste");
			repo.save(p);
		}

		{
			LanguagePair p = new LanguagePair();
			p.setBundle("item_en");
			p.setKey("yoga");
			p.setValue("Yoga Mat");
			repo.save(p);
		}

		ResourceBundle.clearCache();

	}
}
