package com.galaxe.fakecetexamportal;

public class StudentAccademicDetails{
	
	private final int acadamicDetailsId;
	private final String interHallticketNumber;
	private final double interCGPA;
	private final String tenthHallticketNumber;
	private final double tenthCGPA;
	
	public StudentAccademicDetails(int acadamicDetailsId, String interHallticketNumber, double interCGPA,
			String tenthHallticketNumber, double tenthCGPA) {
		
		 if (interHallticketNumber == null || interHallticketNumber.isEmpty()) {
	            throw new IllegalArgumentException("Intermediate hall ticket number cannot be null or empty.");
	     }
		 if (tenthHallticketNumber == null || tenthHallticketNumber.isEmpty()) {
	            throw new IllegalArgumentException("Tenth hall ticket number cannot be null or empty.");
	     }
		 if (interCGPA < 0 || tenthCGPA < 0) {
	            throw new IllegalArgumentException("CGPA cannot be negative.");
	     }
	        
		this.acadamicDetailsId = acadamicDetailsId;
		this.interHallticketNumber = interHallticketNumber;
		this.interCGPA = interCGPA;
		this.tenthHallticketNumber = tenthHallticketNumber;
		this.tenthCGPA = tenthCGPA;
	}

	public int getAcadamicDetailsId() {
		return acadamicDetailsId;
	}


	public String getInterHallticketNumber() {
		return interHallticketNumber;
	}


	public double getInterCGPA() {
		return interCGPA;
	}


	public String getTenthHallticketNumber() {
		return tenthHallticketNumber;
	}


	public double getTenthCGPA() {
		return tenthCGPA;
	}


	
}