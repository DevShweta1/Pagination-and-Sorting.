package com.Demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.dto.TestPage;
import com.Demo.entites.Test;
import com.Demo.service.TestService;

@RestController
@RequestMapping("/tests")
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping
	public TestPage getAllTests(
			@RequestParam (value="pageNumber", defaultValue="1", required = false)Integer pageNumber,
			@RequestParam (value="pageSize", defaultValue="5", required = false) Integer pageSize,
			@RequestParam (value="sortBy", defaultValue="id", required = false)String sortBy){
		return testService.getAllTest(pageNumber, pageSize, sortBy);
	}
			

	@GetMapping("/{id}")
	public Test getTestById(@PathVariable int id) {
		return testService.getTestById(id);
	}

	@PostMapping
	public void saveTest(@RequestBody Test test) {
		testService.saveTest(test);
	}

	@DeleteMapping("/{id}")
	public void deleteTestById(@PathVariable int id) {
		testService.deleteTestById(id);
	}

}
