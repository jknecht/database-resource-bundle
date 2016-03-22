package com.jeffknecht.rbtest.db;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LanguagePairRepository extends CrudRepository<LanguagePair, LanguagePairId> {
	
	@Query("select lp from LanguagePair lp where lp.bundle = ?1")
	List<LanguagePair> findByBundle(String bundle);

}
