package com.Demo.service;

import java.util.List;

import com.Demo.dto.TestPage;
import com.Demo.entites.Test;

public interface TestService {
	TestPage getAllTest(Integer pageNumber, Integer pageSize, String sortBy);

	void saveTest(Test test);

	Test getTestById(int id);

	void deleteTestById(int id);

	// List<Test> findByFilter(Test test);

	// Page<Test> getByPageable(String test, Pageable pageable);

	// Page<Test> findPaginated(int page, int elementsPerPage);

	// ResponseEntity<Test> testGet(PageRequest pageRequest);

}
