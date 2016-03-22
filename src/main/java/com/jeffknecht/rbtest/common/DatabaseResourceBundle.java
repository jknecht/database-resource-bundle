package com.jeffknecht.rbtest.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jeffknecht.rbtest.db.ResourceBundleItem;
import com.jeffknecht.rbtest.db.ResourceBundleRepository;

import sun.util.ResourceBundleEnumeration;

public class DatabaseResourceBundle extends ResourceBundle {
	ResourceBundleRepository languagePairRepository;
	String bundleName; 
	String format;
	ClassLoader loader;
	boolean reload;
	Map<String, Object> lookup;
	
	public DatabaseResourceBundle(ResourceBundleRepository languagePairRepository, String bundleName, String format, ClassLoader loader, boolean reload) {
		super();
		this.languagePairRepository = languagePairRepository;
		this.bundleName = bundleName;
		this.lookup = new HashMap<>();
		for (ResourceBundleItem pair : languagePairRepository.findByBundle(bundleName)) {
			lookup.put(pair.getKey(), pair.getValue());
		}

	}

	@Override
	protected Object handleGetObject(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return lookup.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
        ResourceBundle parent = this.parent;
        return new ResourceBundleEnumeration(lookup.keySet(), (parent != null) ? parent.getKeys() : null);
	}
}
