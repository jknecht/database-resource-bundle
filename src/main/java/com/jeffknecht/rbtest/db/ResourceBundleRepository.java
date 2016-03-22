package com.jeffknecht.rbtest.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ResourceBundleRepository extends CrudRepository<ResourceBundleItem, ResourceBundleItemId> {
	
	@Query("select rbi from ResourceBundleItem rbi where rbi.bundle = ?1")
	List<ResourceBundleItem> findByBundle(String bundle);

}
