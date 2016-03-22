package com.jeffknecht.rbtest;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jeffknecht.rbtest.db.LanguagePair;
import com.jeffknecht.rbtest.db.LanguagePairRepository;

import sun.util.ResourceBundleEnumeration;

public class DatabaseResourceBundle extends ResourceBundle {
	LanguagePairRepository languagePairRepository;
	String bundleName; 
	String format;
	ClassLoader loader;
	boolean reload;
	Map<String, Object> lookup;
	
	public DatabaseResourceBundle(LanguagePairRepository languagePairRepository, String bundleName, String format, ClassLoader loader, boolean reload) {
		super();
		this.languagePairRepository = languagePairRepository;
		this.bundleName = bundleName;
		System.err.println("initializing " + bundleName);
		this.lookup = new HashMap<>();
		for (LanguagePair pair : languagePairRepository.findByBundle(bundleName)) {
			System.err.println("key: " + pair.getKey());
			lookup.put(pair.getKey(), pair.getValue());
		}

	}

	@Override
	protected Object handleGetObject(String key) {
		System.err.println("handleGetObject: " + bundleName + ", " + key);

        if (key == null) {
            throw new NullPointerException();
        }
        return lookup.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		System.err.println("getKeys: " + bundleName);

        ResourceBundle parent = this.parent;
        System.err.println("Parent: " + parent);
        return new ResourceBundleEnumeration(lookup.keySet(), (parent != null) ? parent.getKeys() : null);

	}


}
