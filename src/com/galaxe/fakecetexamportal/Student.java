package com.galaxe.fakecetexamportal;


public class Student{
	
	private String RegistrationId;
	private StudentPersonalDetails personalDetails;
	private StudentAccademicDetails academicDetails;
	private ExamPaymentDetails paymentDetails;
	private Hallticket hallticket;
	private Exam exam;
	private boolean ExamAttended=false;

	
	public Student(Student student) {
		this.RegistrationId=student.getRegistrationId();
		this.personalDetails=student.getPersonalDetails();
		this.academicDetails=student.getAcademicDetails();
		this.hallticket=student.getHallticket();
		this.exam=student.getExam();
	}
	
	public Student(String registrationNumber) {
		Student student = FakeCetExamPortal.students.stream()
	            .filter(s -> s.getRegistrationId().equals(registrationNumber) && s.isExamAttended())
	            .findFirst()
	            .orElseThrow(() -> new IllegalArgumentException("No student found with registration number: " + registrationNumber+" or He/She not given the Exam"));
		
		this.RegistrationId=student.getRegistrationId();
		this.personalDetails=student.getPersonalDetails();
		this.academicDetails=student.getAcademicDetails();
		this.hallticket=student.getHallticket();
		this.exam=student.getExam();
	}
	
//	public Student() {
//		FakeCetExamPortal.students.add(this);
//	}
	
	public Student(StudentPersonalDetails personalDetails, StudentAccademicDetails academicDetails) {
		this.personalDetails = personalDetails;
		this.academicDetails = academicDetails;
	}
	
	public String getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(String registrationId) {
		RegistrationId = registrationId;
	}
	public StudentPersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(StudentPersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public StudentAccademicDetails getAcademicDetails() {
		return academicDetails;
	}
	public void setAcademicDetails(StudentAccademicDetails academicDetails) {
		this.academicDetails = academicDetails;
	}
	public ExamPaymentDetails getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(ExamPaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public Hallticket getHallticket() {
		return hallticket;
	}
	public void setHallticket(Hallticket hallticket) {
		this.hallticket = hallticket;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public boolean isExamAttended() {
		return ExamAttended;
	}

	public void setExamAttended(boolean examAttended) {
		ExamAttended = examAttended;
	}
	
	
	
	public void displayStudentDetails() {
        System.out.println("Student ID: " + this.getPersonalDetails().getStudentId());
        System.out.println("Name: " + this.getPersonalDetails().getStudentName());
        System.out.println("Father's Name: " + this.getPersonalDetails().getFatherName());
        System.out.println("Mother's Name: " + this.getPersonalDetails().getMotherName());
        System.out.println("Date of Birth: " + this.getPersonalDetails().getDateofBith());
        System.out.println("Aadhar Number: " + this.getPersonalDetails().getAadharnumber());
        System.out.println("City: " + this.getPersonalDetails().getCity());
        System.out.println("Caste: " + this.getPersonalDetails().getCaste());
        System.out.println("Inter Hall Ticket: " + this.getAcademicDetails().getInterHallticketNumber());
        System.out.println("Inter CGPA: " + this.getAcademicDetails().getInterCGPA());
        System.out.println("Tenth Hall Ticket: " + this.getAcademicDetails().getTenthHallticketNumber());
        System.out.println("Tenth CGPA: " + this.getAcademicDetails().getTenthCGPA());
        System.out.println("----------------------------");
    }
}