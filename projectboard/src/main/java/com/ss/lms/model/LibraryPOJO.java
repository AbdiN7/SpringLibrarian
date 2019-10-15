package com.ss.lms.model;

public class LibraryPOJO {

	private String bookTitle;
	private String branchName;
	private int noOfCopies;

	public LibraryPOJO() {
		
	}
	
	public LibraryPOJO(String book, String branch, int number) {
		this.bookTitle = book;
		this.branchName = branch;
		this.noOfCopies = number;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
}
