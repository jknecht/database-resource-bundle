package com.jeffknecht.rbtest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.jeffknecht.rbtest.db.LanguagePairRepository;

public class DatabaseBundleControl extends ResourceBundle.Control {

	public static final List<String> FORMAT_DATABASE = Collections.unmodifiableList(Arrays.asList("bundle.database"));
	private LanguagePairRepository repository;
	
	
	
	public DatabaseBundleControl(LanguagePairRepository repository) {
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
		System.err.println("getCandidateLocales: " + baseName + ", " + locale);
		List<Locale> locales = super.getCandidateLocales(baseName, locale);
		System.err.println(locales);
		return locales;
	}
	
	
	
	

}
