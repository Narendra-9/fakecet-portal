package com.galaxe.fakecetcounslingportal;

import java.util.HashMap;
import java.util.Map;

public class College {
	
	  private String collegeName;
	  private Map<String, Branch> branches;

	  public College(String name) {
	      this.collegeName = name;
	      this.branches = new HashMap<>();
	  }

	  public void addBranch(String branchName, int availableSeatsGeneral,int availableSeatsBC, int availableSeatsSC, int availableSeatsST) {
	      this.branches.put(branchName, new Branch(branchName, availableSeatsGeneral, availableSeatsBC, availableSeatsSC, availableSeatsST));
	  }

	  public boolean hasAvailableSeats(String branchName, String caste) {
	      return branches.get(branchName).getAvailableSeats(caste) > 0;
	  }

	  public Map<String, Branch> getBranches() {
	      return branches;
	  }

	  public String getCollegeName() {
	      return collegeName;
	  }
	  

		@Override
		public String toString() {
			return collegeName ;
		}
	  
	  
	}