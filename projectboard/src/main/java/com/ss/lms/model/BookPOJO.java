package com.ss.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_book", schema = "library")
public class BookPOJO {

	@Id
	private int bookId;
	private String title;
	
	public BookPOJO() {}
	
	public BookPOJO(int id, String title) {
		this.bookId = id;
		this.title = title;
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String bookTitle) {
		this.title = bookTitle;
	}
}
