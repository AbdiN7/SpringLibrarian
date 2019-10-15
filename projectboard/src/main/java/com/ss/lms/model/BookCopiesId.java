package com.ss.lms.model;

import java.io.Serializable;

public class BookCopiesId implements Serializable{

	private int bookId;
	
	private int branchId;
	
	public BookCopiesId() {}
	
	public BookCopiesId(int book, int branch) {
		this.bookId = book;
		this.branchId = branch;
	}
	
}
