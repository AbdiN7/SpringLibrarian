package com.ss.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.model.BookCopies;
import com.ss.lms.model.Branch;
import com.ss.lms.services.LibrarianService;


@RestController
@RequestMapping("/lms/librarian/")
public class LibrarianController {
	 
	@Autowired
	private LibrarianService library;
	
	@GetMapping("branches")
	@ResponseBody public ResponseEntity<?> getBranches(){
		Iterable<Branch> branch = library.getBranches();
		return new ResponseEntity<Iterable<Branch>>(branch, HttpStatus.OK);
	}
	
	@GetMapping("branch/{branchId}")
	@ResponseBody public ResponseEntity<?> getBranchInfo(@PathVariable int branchId){
		Branch branch = library.getBranchInfo(branchId);
		
		if(branch == null) {
			return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Branch>(branch, HttpStatus.OK);	
		}
	}
	
	@PutMapping("branch/{branchId}")
	@ResponseBody public ResponseEntity<?> updateBranch(@PathVariable int branchId, @RequestBody Branch updateBranch){
		Branch branch = library.getBranchInfo(branchId);
		
		if(branch == null) {			
			return new ResponseEntity<String>("Branch does not exist", HttpStatus.NOT_FOUND);
		}else {
			branch.setBranchName(updateBranch.getBranchName());
			branch.setBranchAddress(updateBranch.getBranchAddress());
			library.save(branch);
			return new ResponseEntity<Branch>(branch, HttpStatus.ACCEPTED);
		}
		
	}
	
	@GetMapping("branch/{branchId}/books")
	@ResponseBody public ResponseEntity<?> getBooks(@PathVariable int branchId) {
		Branch branch = library.getBranchInfo(branchId);
		if(branch == null) {
			return new ResponseEntity<String>("Branch does not exist", HttpStatus.NOT_FOUND);
		}else {
		Iterable<BookCopies> lib = library.getBooks(branchId);
		return new ResponseEntity<Iterable<BookCopies>>(lib, HttpStatus.OK);
		}
	}
	
	@GetMapping("branch/{branchId}/book/{bookId}")
	@ResponseBody public ResponseEntity<?> getBookInfo(@PathVariable int branchId, @PathVariable int bookId) {
		BookCopies lib = library.getBookInfo(bookId, branchId);
		
		if(lib.getBook().getTitle() == null) {
			return new ResponseEntity<String>("No Books with that ID exists at this Branch", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<BookCopies>(lib, HttpStatus.OK);	
		}
	}
	
	@PutMapping("branch/{branchId}/book/{bookId}")
	@ResponseBody public ResponseEntity<?> updateNoofCopies(@PathVariable int branchId, @PathVariable int bookId, @RequestBody BookCopies newCopies) {
		BookCopies lib = library.addCopies(branchId, bookId, newCopies);
		if(lib.getBook().getTitle() == null) {
			return new ResponseEntity<String>("No Books with that ID exists at this Branch", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<BookCopies>(lib, HttpStatus.ACCEPTED);	
		}
	}
}
