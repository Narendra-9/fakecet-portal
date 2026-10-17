package com.galaxe.fakecetexamportal;

public class Exam{
	
	private final String hallticketNumber;
	private final int mathsMarks;
	private final int physicsMarks;
	private final int chemistryMarks;
	private final int totalMarks;
	private int rank;
	
	public Exam(String hallticketNumber,int mathsMarks, int physicsMarks, int chemistryMarks) {
		
		if (mathsMarks < 0 || physicsMarks < 0 || chemistryMarks < 0) {
            throw new IllegalArgumentException("Marks cannot be negative.");
        }
		
		this.hallticketNumber = hallticketNumber;
		this.mathsMarks = mathsMarks;
		this.physicsMarks = physicsMarks;
		this.chemistryMarks = chemistryMarks;
		this.totalMarks=mathsMarks+physicsMarks+chemistryMarks;
	}

	public String getHallticketNumber() {
		return hallticketNumber;
	}

	public int getMathsMarks() {
		return mathsMarks;
	}

	public int getPhysicsMarks() {
		return physicsMarks;
	}

	public int getChemistryMarks() {
		return chemistryMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return " hallticketNumber :" + hallticketNumber + "\n mathsMarks :" + mathsMarks + "\n physicsMarks :"
				+ physicsMarks + "\n chemistryMarks :" + chemistryMarks + "\n totalMarks :" + totalMarks + "\n rank :" + rank+"\n";
	}
	
	
}