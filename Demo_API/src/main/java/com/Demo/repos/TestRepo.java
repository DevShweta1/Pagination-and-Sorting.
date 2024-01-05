package com.Demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.entites.Test;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer> {

	// public Page<Test> queryFirst3ByTest(String test, Pageable pageable);
	// @Query("SELECT u FROM TestEntity u WHERE u.id LIKE CONCAT('%',:search,'%')Or
	// u.name LIKE CONCAT('%',:search,'%')Or u.Category LIKE
	// CONCAT('%',:search,'%')Or u.Messages LIKE CONCAT('%',:search,'%')Or
	// u.Timestamp LIKE CONCAT('%',:search,'%')Or u.Action LIKE
	// CONCAT('%',:search,'%')Or u.Status LIKE CONCAT('%',:search,'%')")

	// public Page<Test> search(Object search, Pageable p);

}
