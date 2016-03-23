package com.jeffknecht.rbtest.db;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity @IdClass(ResourceBundleItemId.class) @Table(name="resource_bundle")
public class ResourceBundleItem {
	@Id private String bundle;	
	@Id @Column(name="property_key") private String key;
	@Column(name="property_value") private String value;
	@LastModifiedDate private Timestamp lastModifiedDateTime;
	
	public String getBundle() {
		return bundle;
	}
	public void setBundle(String bundle) {
		this.bundle = bundle;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Timestamp getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	@PrePersist
	@PreUpdate
	void lastModifiedDateTime() {
		this.lastModifiedDateTime = new Timestamp(new Date().getTime());
	}
	
}
