package com.ss.lms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.lms.dao.BookCopiesDAO;
import com.ss.lms.dao.BranchDAO;
import com.ss.lms.model.BookCopies;
import com.ss.lms.model.Branch;


@Service
public class LibrarianService {
	
	@Autowired 
	private BranchDAO branch;
	
	@Autowired
	private BookCopiesDAO copies;
	
	public Iterable<Branch> getBranches() {
		return branch.findAll();
	}
	
	public Branch getBranchInfo(int branchId) {
		return branch.getByBranchId(branchId);
	}
	
	public Branch save(Branch updateBranch) {
		Branch branchCheck = branch.getByBranchId(updateBranch.getBranchId());
		
		if(branchCheck == null) {return new Branch();}
		return branch.save(updateBranch);
	}
	
	public Iterable<BookCopies> getBooks(int branchId) {
		
		List<BookCopies> output = new ArrayList<>();
		copies.getByIdBranchId(branchId).forEach(entry->{
			BookCopies lib = new BookCopies();
			lib.setBook(entry.getBook());
			lib.setBranch(entry.getBranch());
			lib.setNoOfCopies(entry.getNoOfCopies());
			output.add(lib);
		});;
		return output;
	}
	
	public BookCopies getBookInfo(int bookId, int branchId) {
		
		BookCopies result = copies.getByIdBranchIdAndIdBookId(branchId, bookId);
		BookCopies lib = new BookCopies();
		if(result == null) {return lib;}
		
		lib.setBook(result.getBook());
		lib.setBranch(result.getBranch());
		lib.setNoOfCopies(result.getNoOfCopies());
		return lib;
	}
	
	public BookCopies addCopies(int branchId, int bookId, BookCopies newCopies) {
		BookCopies result = copies.getByIdBranchIdAndIdBookId(branchId, bookId);
		BookCopies lib = new BookCopies();
		if(result == null) {return lib;}
		
		copies.save(result);
		lib.setBook(result.getBook());
		lib.setBranch(result.getBranch());
		lib.setNoOfCopies(result.getNoOfCopies() + newCopies.getNoOfCopies());
		return lib;
	}
	
}
