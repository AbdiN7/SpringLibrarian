package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.BookCopies;
import com.ss.lms.model.BookCopiesId;

@Repository
public interface BookCopiesDAO extends CrudRepository<BookCopies, BookCopiesId>{
	
	public Iterable<BookCopies> getByIdBranchId(int branchId);
	
	public BookCopies getByIdBranchIdAndIdBookId(int branchId, int bookId);
}