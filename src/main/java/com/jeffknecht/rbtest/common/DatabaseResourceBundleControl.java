package com.jeffknecht.rbtest.common;

import java.io.IOException;
import java.sql.Timestamp;
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
	public long getTimeToLive(String baseName, Locale locale) {
        if (baseName == null || locale == null) {
            throw new NullPointerException();
        }
        // hard-coded 15 seconds for demonstration purposes
        return 15000;
	}
	
	@Override
	public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle,
			long loadTime) {
		if (!FORMAT_DATABASE.contains(format)) {
			return super.needsReload(baseName, locale, format, loader, bundle, loadTime);
		}
		
		/*
		 * return true if the database table has been emptied, but the bundle is not.
		 * return true if the latest timestamp is newer than the supplied loadTime of the current bundle
		 */
		Timestamp newestItemTimestamp = repository.findNewestTimestamp(toBundleName(baseName, locale));
		return ((newestItemTimestamp == null && bundle.getKeys().hasMoreElements()) || newestItemTimestamp.getTime() > loadTime);
		
	}
}
