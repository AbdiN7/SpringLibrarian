package com.ss.lms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.lms.dao.BookCopiesDAO;
import com.ss.lms.dao.BookDAO;
import com.ss.lms.dao.BranchDAO;
import com.ss.lms.model.BranchPOJO;
import com.ss.lms.model.LibraryBook;
import com.ss.lms.model.LibraryPOJO;


@Service
public class LibrarianService {
	
	@Autowired 
	private BranchDAO branch;
	
	@Autowired
	private BookDAO book;
	
	@Autowired
	private BookCopiesDAO copies;
	
	public Iterable<BranchPOJO> getBranches() {
		return branch.findAll();
	}
	
	public BranchPOJO getBranchInfo(int branchId) {
		return branch.getByBranchId(branchId);
	}
	
	public BranchPOJO save(BranchPOJO updateBranch) {
		BranchPOJO branchCheck = branch.getByBranchId(updateBranch.getBranchId());
		
		if(branchCheck == null) {return new BranchPOJO();}
		return branch.save(updateBranch);
	}
	
	public Iterable<LibraryPOJO> getBooks(int branchId) {
		
		List<LibraryPOJO> output = new ArrayList<>();
		copies.getByBranchId(branchId).forEach(entry->{
			LibraryPOJO lib = new LibraryPOJO();
			lib.setBookTitle(book.getByBookId(entry.getBookId()).getTitle());
			lib.setBranchName(branch.getByBranchId(entry.getBranchId()).getBranchName());
			lib.setNoOfCopies(entry.getNoOfCopies());
			output.add(lib);
		});;
		return output;
	}
	
	public LibraryPOJO getBookInfo(int bookId, int branchId) {
		
		LibraryBook result = copies.getByBranchIdAndBookId(branchId, bookId);
		
		if(result == null) {return new LibraryPOJO();}
		LibraryPOJO lib = new LibraryPOJO();
		lib.setBookTitle(book.getByBookId(result.getBookId()).getTitle());
		lib.setBranchName(branch.getByBranchId(result.getBranchId()).getBranchName());
		lib.setNoOfCopies(result.getNoOfCopies());
		return lib;
	}
	
	public LibraryPOJO addCopies(int branchId, int bookId, LibraryPOJO newCopies) {
		LibraryBook result = copies.getByBranchIdAndBookId(branchId, bookId);
		
		if(result == null) {return new LibraryPOJO();}
		result.addCopies(newCopies.getNoOfCopies());
		copies.save(result);
		
		LibraryPOJO lib = new LibraryPOJO();
		lib.setBookTitle(book.getByBookId(result.getBookId()).getTitle());
		lib.setBranchName(branch.getByBranchId(result.getBranchId()).getBranchName());
		lib.setNoOfCopies(result.getNoOfCopies());
		return lib;
	}
	
}
