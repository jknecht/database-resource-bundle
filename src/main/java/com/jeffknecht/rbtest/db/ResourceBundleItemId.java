package com.jeffknecht.rbtest.db;

import java.io.Serializable;

public class ResourceBundleItemId implements Serializable {
	private static final long serialVersionUID = -1242057927277410310L;
	private String bundle;	
	private String key;
	
	public ResourceBundleItemId() {}
	
	public ResourceBundleItemId(String bundleName, String key) {
		this.bundle = bundleName;
		this.key = key;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bundle == null) ? 0 : bundle.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceBundleItemId other = (ResourceBundleItemId) obj;
		if (bundle == null) {
			if (other.bundle != null)
				return false;
		} else if (!bundle.equals(other.bundle))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
