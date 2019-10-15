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

import com.ss.lms.model.BranchPOJO;
import com.ss.lms.model.LibraryPOJO;
import com.ss.lms.services.LibrarianService;


@RestController
@RequestMapping("/lms/librarian/")
public class LibrarianController {
	
	@Autowired
	private LibrarianService library;
	
	@GetMapping("test")
	@ResponseBody public String test() {
		return "test";
	}

	@GetMapping("branches")
	@ResponseBody public ResponseEntity<?> getBranches(){
		Iterable<BranchPOJO> branch = library.getBranches();
		return new ResponseEntity<Iterable<BranchPOJO>>(branch, HttpStatus.OK);
	}
	
	//404 
	@GetMapping("branch/{branchId}")
	@ResponseBody public ResponseEntity<?> getBranchInfo(@PathVariable int branchId){
		BranchPOJO branch = library.getBranchInfo(branchId);
		
		if(branch == null) {
			return new ResponseEntity<String>("Data not found", HttpStatus.OK);
		}else {
			return new ResponseEntity<BranchPOJO>(branch, HttpStatus.OK);	
		}
	}
	
	//bad request (branch doesn't exist)
	@PutMapping("branch/{branchId}")
	@ResponseBody public ResponseEntity<?> updateBranch(@PathVariable int branchId, @RequestBody BranchPOJO updateBranch){
		BranchPOJO branch = library.getBranchInfo(branchId);
		
		if(branch == null) {			
			return new ResponseEntity<String>("Branch does not exist", HttpStatus.ACCEPTED);
		}else {
			branch.setBranchName(updateBranch.getBranchName());
			branch.setBranchAddress(updateBranch.getBranchAddress());
			return new ResponseEntity<BranchPOJO>(branch, HttpStatus.ACCEPTED);
		}
		
	}
	
	//bad request (branch doesn't exist)
	@GetMapping("branch/{branchId}/books")
	@ResponseBody public ResponseEntity<?> getBooks(@PathVariable int branchId) {
		Iterable<LibraryPOJO> lib = library.getBooks(branchId);
		return new ResponseEntity<Iterable<LibraryPOJO>>(lib, HttpStatus.OK);
	}
	
	//404
	@GetMapping("branch/{branchId}/book/{bookId}")
	@ResponseBody public ResponseEntity<?> getBookInfo(@PathVariable int branchId, @PathVariable int bookId) {
		LibraryPOJO lib = library.getBookInfo(bookId, branchId);
		
		if(lib.getBookTitle() == null) {
			return new ResponseEntity<String>("No Books with that ID exists at this Branch", HttpStatus.OK);
		}else {
			return new ResponseEntity<LibraryPOJO>(lib, HttpStatus.OK);	
		}
	}
	
	//bad request (branch doesn't have any of that book)
	@PutMapping("branch/{branchId}/book/{bookId}")
	@ResponseBody public ResponseEntity<?> updateNoofCopies(@PathVariable int branchId, @PathVariable int bookId, @RequestBody LibraryPOJO newCopies) {
		LibraryPOJO lib = library.addCopies(branchId, bookId, newCopies);
		if(lib.getBookTitle() == null) {
			return new ResponseEntity<String>("No Books with that ID exists at this Branch", HttpStatus.OK);
		}else {
			return new ResponseEntity<LibraryPOJO>(lib, HttpStatus.ACCEPTED);	
		}
	}
	
	//Proper HTTP Codes
	//Content negotiation	
}
