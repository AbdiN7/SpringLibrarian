package com.ss.lms.dao;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.ss.lms.model.LibraryPOJO;

//@Repository
public interface LibrarianDAO{
	
public LibraryPOJO getByBranchId(int branchId);

}