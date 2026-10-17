package com.galaxe.fakecetcounslingportal;

public class Option {
	
    private College college;
    private Branch branch; 
    
    public Option(College college,String branchName) {
        this.college = college;
        this.branch=college.getBranches().get(branchName);
    }

    public Branch getBranch() {
        return branch;
    }
    public College getCollege() {
    	return college;
    }
    
    public void setBranch(College clg,String branchName) {
        this.branch = clg.getBranches().get(branchName);
    }

	@Override
	public String toString() {
		return college + "-" + branch;
	}
    
}