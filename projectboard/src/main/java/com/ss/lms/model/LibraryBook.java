package com.ss.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@IdClass(BookCopiesId.class)
@Table (name = "tbl_book_copies", schema="library")
public class LibraryBook {
	@Id
	private int bookId;
	@Id
	private int branchId;
	private Integer noOfCopies;
		
	public LibraryBook() {}
	
	public LibraryBook(int book, int branch, int copies) {
		this.bookId = book;
		this.branchId = branch;
		noOfCopies = copies;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public void addCopies(int newCopies) {
		this.noOfCopies += newCopies;
	}
	
}
