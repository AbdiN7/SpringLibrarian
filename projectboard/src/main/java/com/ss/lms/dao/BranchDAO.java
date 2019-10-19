package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.Branch;

@Repository
public interface BranchDAO extends CrudRepository<Branch, Long>{
	
public Branch getByBranchId(int branchId);

}