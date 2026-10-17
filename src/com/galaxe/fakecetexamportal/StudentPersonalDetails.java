package com.galaxe.fakecetexamportal;

import java.time.LocalDate;

public class StudentPersonalDetails{
	
	private int studentId;
	private String studentName; 
	private String fatherName;
	private String motherName;
	private LocalDate dateofBith;
	private String aadharnumber;
	private String city;
	private String caste;
	
	public StudentPersonalDetails(int studentId, String studentName, String fatherName, String motherName,
			LocalDate dateofBith, String aadharnumber, String city, String caste) throws Exception {
		
		if(FakeCetExamPortal.isready) {
			this.studentId = studentId;
			this.studentName = studentName;
			this.fatherName = fatherName;
			this.motherName = motherName;
			this.dateofBith = dateofBith;
			this.aadharnumber = aadharnumber;
			this.city = city;
			this.caste = caste;
		}
		else {
			throw new Exception("The Site is under maintainence !");
		}
		
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public LocalDate getDateofBith() {
		return dateofBith;
	}
	public void setDateofBith(LocalDate dateofBith) {
		this.dateofBith = dateofBith;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	
}