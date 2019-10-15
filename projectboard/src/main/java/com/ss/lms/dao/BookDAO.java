package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.BookPOJO;

@Repository
public interface BookDAO extends CrudRepository<BookPOJO, Long>{
	
public BookPOJO getByBookId(int bookId);

}