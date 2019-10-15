package com.ss.lms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.lms.model.BranchPOJO;

@Repository
public interface BranchDAO extends CrudRepository<BranchPOJO, Long>{
	
public BranchPOJO getByBranchId(int branchId);

}