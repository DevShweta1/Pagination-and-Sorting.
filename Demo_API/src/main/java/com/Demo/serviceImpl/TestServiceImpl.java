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
		// int pageSize=5;
		// int pageNumber=1;
		Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<Test> pageTest = this.testRepo.findAll(p);
		List<Test> allTest = pageTest.getContent();
		//return allTest;
		
		 TestPage testPage = new TestPage();
			/*
			 * testPage.setTestList(allTest);
			 * testPage.setTotalPages(pageTest.getTotalPages());
			 * testPage.setTotalElements(pageTest.getTotalElements());
			 * testPage.setppageNumber(pageTest.getPageNumber());
			 * testPage.setPageSize(pageTest.getPageSize());
			 * testPage.setlastPage(pageTest.getlastPage());
			 * testPage.setfirstPage(pageTest.getfirstPage());
			 */
		 
		 testPage.setTestList(allTest);
		 testPage.setTotalPages(pageTest.getTotalPages());
		 testPage.setTotalElements(pageTest.getTotalElements());
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

	/*
	 * @Override public ResponseEntity<Test> testGet(PageRequest pageRequest) { if
	 * (!pageRequest.getSortBy().equals("name") &&
	 * !pageRequest.getSortBy().equals("id") &&
	 * !pageRequest.getSortBy().equals("Category") &&
	 * !pageRequest.getSortBy().equals("Messages") &&
	 * !pageRequest.getSortBy().equals("Timestamp") &&
	 * !pageRequest.getSortBy().equals("Action") &&
	 * !pageRequest.getSortBy().equals("Status")) { // throw new ///
	 * InvalidProperty(ConstantsMessage.VALID_PROPERTY_SORT_BY); return new
	 * ResponseEntity<>(new Test(), HttpStatus.FOUND);
	 * 
	 * }
	 */

	/*
	 * Page<Test> pageTest = null; Pageable p =
	 * PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(),
	 * Sort.by(pageRequest.getSortBy())); if (PageRequest.getSearch() == null) {
	 * pageTest = testRepo.findAll(p); } else { pageTest =
	 * testRepo.search(pageRequest.getSearch(), p); } List<Test> testEntityList =
	 * pageTest.getContent();
	 * 
	 * PageResponse pageResponse = new PageResponse(pageTest.getNumber(),
	 * pageTest.getSize(), pageTest.getTotalPages(), pageTest.getTotalElements(),
	 * pageTest.isLast(), pageTest.isFirst()); //
	 * log.info("test get service method called"); List list = new ArrayList<>();
	 * list.add(pageResponse); list.add(testEntityList);
	 * 
	 * return new ResponseEntity<>(new Test(), HttpStatus.FOUND);
	 * 
	 */
}
