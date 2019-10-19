package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.Book;

@Repository
public interface BookDAO extends CrudRepository<Book, Long>{
	
public Book getByBookId(int bookId);

}