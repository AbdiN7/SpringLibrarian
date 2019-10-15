package com.ss.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_library_branch", schema="library")
public class BranchPOJO {
	
	@Id
	private int branchId;
	private String branchName;
	private String branchAddress;
	
	public BranchPOJO() {}
	
	public BranchPOJO(int id, String name, String address) {
		this.branchId = id;
		this.branchName = name;
		this.branchAddress = address;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}	
}
