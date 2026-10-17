package com.galaxe.fakecetexamportal;

public interface FakeCetExamPortalManagement {
	
	void getPaymentforExamfrom(Student student);
	void releaseHalltickets();
	void downloadHallticket(String registrationId);
	void conductExam();
	void takeAttendence(String hallTicketNumber);
	void publishResults();
	void viewResult(String hallticketNumber);
	void downloadRankCard(String hallticketNumber);

	
}
