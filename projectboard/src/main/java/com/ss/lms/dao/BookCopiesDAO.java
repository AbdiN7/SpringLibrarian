package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.BookCopiesId;
import com.ss.lms.model.LibraryBook;

@Repository
public interface BookCopiesDAO extends CrudRepository<LibraryBook, BookCopiesId>{
	
	public Iterable<LibraryBook> getByBranchId(int branchId);
	
	public LibraryBook getByBranchIdAndBookId(int branchId, int bookId);
}