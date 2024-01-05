package com.Demo.dto;

import java.util.List;

import com.Demo.entites.Test;

public class TestPage {

	private List<Test> testList;
	private Integer pageNumber;

	private Integer pageSize;

	private Integer totalPages;

	private long totalElements;

	private boolean lastPage;

	private boolean firstPage;

	public TestPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestPage(List<Test> testList, Integer pageNumber, Integer pageSize, Integer totalPages, long totalElements,
			boolean lastPage, boolean firstPage) {
		super();
		this.testList = testList;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.lastPage = lastPage;
		this.firstPage = firstPage;
	}

	public List<Test> getTestList() {
		return testList;
	}

	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

}
