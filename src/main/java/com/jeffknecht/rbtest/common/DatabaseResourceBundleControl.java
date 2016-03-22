package com.jeffknecht.rbtest.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.jeffknecht.rbtest.db.ResourceBundleRepository;

public class DatabaseResourceBundleControl extends ResourceBundle.Control {

	public static final List<String> FORMAT_DATABASE = Collections.unmodifiableList(Arrays.asList("bundle.database"));
	private ResourceBundleRepository repository;
	
	public DatabaseResourceBundleControl(ResourceBundleRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<String> getFormats(String baseName) {
        if (baseName == null) {
            throw new NullPointerException();
        }
		return FORMAT_DATABASE;
	}

	@Override
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {
		return new DatabaseResourceBundle(repository, toBundleName(baseName, locale), format, loader, reload);
	}

	@Override
	public List<Locale> getCandidateLocales(String baseName, Locale locale) {
		return super.getCandidateLocales(baseName, locale);
	}
	
	
	
	

}
