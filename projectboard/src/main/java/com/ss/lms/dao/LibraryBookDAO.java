package com.ss.lms.dao;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.ss.lms.model.LibraryBook;

//@Repository
public interface LibraryBookDAO{
	
	public Iterable<LibraryBook> getByBranchId(Integer BranchId);
	
	public Iterable<LibraryBook> getByBookId(Integer BookId);
}