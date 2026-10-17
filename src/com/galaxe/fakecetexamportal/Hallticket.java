package com.galaxe.fakecetexamportal;

import java.time.LocalDate;


public class Hallticket{
	
	private final String hallticketNumber;
	private final String candidateName;
	private final String examcentre;
	private final LocalDate dateOfExam;
	
	public Hallticket(String hallticketNumber,String candidateName, String examCentre, LocalDate dateOfExam) {
		
		 if (hallticketNumber == null || hallticketNumber.isEmpty()) {
	         throw new IllegalArgumentException("Hall ticket number cannot be null or empty.");
	     }
	     if (candidateName == null || candidateName.isEmpty()) {
	         throw new IllegalArgumentException("Candidate name cannot be null or empty.");
	     }
	     if (examCentre == null || examCentre.isEmpty()) {
	         throw new IllegalArgumentException("Exam centre cannot be null or empty.");
	     }
	     if (dateOfExam == null) {
	         throw new IllegalArgumentException("Date of exam cannot be null.");
	     }
		
		this.hallticketNumber = hallticketNumber;
		this.candidateName=candidateName;
		this.examcentre = examCentre;
		this.dateOfExam = dateOfExam;
	}

	public String getHallticketnumber() {
		return hallticketNumber;
	}



	public String getExamcentre() {
		return examcentre;
	}



	public LocalDate getDateOfExam() {
		return dateOfExam;
	}


	public String getCandidateName() {
		return candidateName;
	}

	
}