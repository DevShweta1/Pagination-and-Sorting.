package com.Demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Demo.dto.TestPage;
import com.Demo.entites.Test;
import com.Demo.repos.TestRepo;
import com.Demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepo testRepo;

	@Override
	public TestPage getAllTest(Integer pageNumber, Integer pageSize, String sortBy) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<Test> pageTest = this.testRepo.findAll(p);
		List<Test> allTest = pageTest.getContent();
		
		 TestPage testPage = new TestPage();
		
		 testPage.setTestList(allTest);
		 testPage.setTotalPages(pageTest.getTotalPages());
		 testPage.setTotalElements(pageTest.getTotalElements());
		 testPage.setPageNumber(pageTest.getNumber() + 1); // Page numbers are zero-based
		 testPage.setPageSize(pageTest.getSize());
		 testPage.setLastPage(pageTest.isLast());
		 testPage.setFirstPage(pageTest.isFirst());

		    
		    return testPage;

	}

	@Override
	public void saveTest(Test test) {
		this.testRepo.save(test);
	}

	@Override
	public Test getTestById(int id) {
		Optional<Test> optional = testRepo.findById(id);
		Test test = null;
		if (optional.isPresent()) {
			test = optional.get();
		} else {
			throw new RuntimeException("Test not found for id :: " + id);

		}
		return test;
	}

	@Override
	public void deleteTestById(int id) {
		this.testRepo.deleteById(id);

	}

}
