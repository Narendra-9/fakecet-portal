package com.galaxe.main;

import java.time.LocalDate;
import com.galaxe.fakecetcounslingportal.Admin;
import com.galaxe.fakecetcounslingportal.Candidate;
import com.galaxe.fakecetcounslingportal.College;
import com.galaxe.fakecetcounslingportal.Option;
import com.galaxe.fakecetexamportal.FakeCetExamPortal;
import com.galaxe.fakecetexamportal.Student;
import com.galaxe.fakecetexamportal.StudentAccademicDetails;
import com.galaxe.fakecetexamportal.StudentPersonalDetails;

public class Main {
	
	

	public static void main(String[] args) throws Exception {
		
		
		FakeCetExamPortal fakeCetExamPortal=new FakeCetExamPortal();
		
//		Filling Student Personal Details
		StudentPersonalDetails personal1 = new StudentPersonalDetails(1, "Rajesh Kumar", "Ramachandra", "Lakshmi", 
                LocalDate.of(2000, 5, 20), "123456789012", "Kakinada", "General");
        StudentPersonalDetails personal2 = new StudentPersonalDetails(2, "Priya Reddy", "Narasimha", "Sita", 
                LocalDate.of(2001, 8, 15), "123456789013", "Bhimavaram", "OBC");
        StudentPersonalDetails personal3 = new StudentPersonalDetails(3, "Vijay Kumar", "Krishna", "Radha", 
                LocalDate.of(2002, 3, 10), "123456789014", "Rajahmundry", "SC");
        StudentPersonalDetails personal4 = new StudentPersonalDetails(4, "Anjali", "Satyanarayana", "Gowri", 
                LocalDate.of(2000, 12, 25), "123456789015", "Kakinada", "ST");
        StudentPersonalDetails personal5 = new StudentPersonalDetails(5, "Karthik", "Venkat", "Lakshmi", 
                LocalDate.of(2001, 1, 30), "123456789016", "Bhimavaram", "General");
        StudentPersonalDetails personal6 = new StudentPersonalDetails(6, "Suresh", "Raju", "Madhavi", 
                LocalDate.of(2002, 4, 18), "123456789017", "Rajahmundry", "OBC");
        StudentPersonalDetails personal7 = new StudentPersonalDetails(7, "Sneha", "Chandra", "Nirmala", 
                LocalDate.of(2000, 11, 5), "123456789018", "Kakinada", "General");
        StudentPersonalDetails personal8 = new StudentPersonalDetails(8, "Ajay", "Krishna", "Suma", 
                LocalDate.of(2001, 2, 22), "123456789019", "Bhimavaram", "SC");
        StudentPersonalDetails personal9 = new StudentPersonalDetails(9, "Pooja", "Raghava", "Savita", 
                LocalDate.of(2002, 7, 30), "123456789020", "Rajahmundry", "ST");
        StudentPersonalDetails personal10 = new StudentPersonalDetails(10, "Ravi", "Vijaya", "Vani", 
                LocalDate.of(2001, 9, 12), "123456789021", "Kakinada", "General");
        
//      Filling Students Academic Details
        StudentAccademicDetails academic1 = new StudentAccademicDetails(101, "HT123456", 9.5, "THT987654", 10.0);
        StudentAccademicDetails academic2 = new StudentAccademicDetails(102, "HT123457", 8.7, "THT987655", 9.2);
        StudentAccademicDetails academic3 = new StudentAccademicDetails(103, "HT123458", 7.8, "THT987656", 8.0);
        StudentAccademicDetails academic4 = new StudentAccademicDetails(104, "HT123459", 6.5, "THT987657", 7.5);
        StudentAccademicDetails academic5 = new StudentAccademicDetails(105, "HT123460", 9.0, "THT987658", 9.8);
        StudentAccademicDetails academic6 = new StudentAccademicDetails(106, "HT123461", 8.4, "THT987659", 9.1);
        StudentAccademicDetails academic7 = new StudentAccademicDetails(107, "HT123462", 9.7, "THT987660", 10.0);
        StudentAccademicDetails academic8 = new StudentAccademicDetails(108, "HT123463", 7.9, "THT987661", 8.5);
        StudentAccademicDetails academic9 = new StudentAccademicDetails(109, "HT123464", 6.8, "THT987662", 7.2);
        StudentAccademicDetails academic10 = new StudentAccademicDetails(110, "HT123465", 8.2, "THT987663", 9.0);
	
        
//      Creating student objects
        Student student1 = new Student(personal1, academic1);
        Student student2 = new Student(personal2, academic2);
        Student student3 = new Student(personal3, academic3);
        Student student4 = new Student(personal4, academic4);
        Student student5 = new Student(personal5, academic5);
        Student student6 = new Student(personal6, academic6);
        Student student7 = new Student(personal7, academic7);
        Student student8 = new Student(personal8, academic8);
        Student student9 = new Student(personal9, academic9);
        Student student10 = new Student(personal10, academic10);

        
//      do payment to get added in the system
        fakeCetExamPortal.getPaymentforExamfrom(student1);
        fakeCetExamPortal.getPaymentforExamfrom(student2);
        fakeCetExamPortal.getPaymentforExamfrom(student3);
        fakeCetExamPortal.getPaymentforExamfrom(student4);
        fakeCetExamPortal.getPaymentforExamfrom(student5);
        fakeCetExamPortal.getPaymentforExamfrom(student6);
        fakeCetExamPortal.getPaymentforExamfrom(student7);
        fakeCetExamPortal.getPaymentforExamfrom(student8);
        fakeCetExamPortal.getPaymentforExamfrom(student9);
        fakeCetExamPortal.getPaymentforExamfrom(student10);
        
//       releasing halltickets for the students
        fakeCetExamPortal.releaseHalltickets();
        
//        students downloads the hallticket here the halltickets will be downloaded to hallticket folder in the directory
        fakeCetExamPortal.downloadHallticket("RN123456");
        fakeCetExamPortal.downloadHallticket("RN123457");
        fakeCetExamPortal.downloadHallticket("RN123458");
        fakeCetExamPortal.downloadHallticket("RN123459");
        fakeCetExamPortal.downloadHallticket("RN123460");
        fakeCetExamPortal.downloadHallticket("RN123461");
        fakeCetExamPortal.downloadHallticket("RN123462");
        fakeCetExamPortal.downloadHallticket("RN123463");
        fakeCetExamPortal.downloadHallticket("RN123464");
        fakeCetExamPortal.downloadHallticket("RN123465");
        
//        exam will be conducted by board
        fakeCetExamPortal.conductExam();
        
//      student takes the exam
        fakeCetExamPortal.takeAttendence("FC123456");
        fakeCetExamPortal.takeAttendence("FC123457");
        fakeCetExamPortal.takeAttendence("FC123458");
        fakeCetExamPortal.takeAttendence("FC123459");
        fakeCetExamPortal.takeAttendence("FC123460");
        fakeCetExamPortal.takeAttendence("FC123461");
        fakeCetExamPortal.takeAttendence("FC123462");
        fakeCetExamPortal.takeAttendence("FC123463");
        fakeCetExamPortal.takeAttendence("FC123464");
        fakeCetExamPortal.takeAttendence("FC123465");
        
//        Board publishes the results
        fakeCetExamPortal.publishResults();
        
//        student views the result
        fakeCetExamPortal.viewResult("FC123456");
        fakeCetExamPortal.viewResult("FC123457");
        fakeCetExamPortal.viewResult("FC123458");
        fakeCetExamPortal.viewResult("FC123459");
        fakeCetExamPortal.viewResult("FC123460");
        fakeCetExamPortal.viewResult("FC123461");
        fakeCetExamPortal.viewResult("FC123462");
        fakeCetExamPortal.viewResult("FC123463");
        fakeCetExamPortal.viewResult("FC123464");
        fakeCetExamPortal.viewResult("FC123465");
        
//        student donwload's the rankcard, the rank card wil be downloaded to Rankcard folder in the directory
        fakeCetExamPortal.downloadRankCard("FC123456");
        fakeCetExamPortal.downloadRankCard("FC123457");
        fakeCetExamPortal.downloadRankCard("FC123458");
        fakeCetExamPortal.downloadRankCard("FC123459");
        fakeCetExamPortal.downloadRankCard("FC123460");
        fakeCetExamPortal.downloadRankCard("FC123461");
        fakeCetExamPortal.downloadRankCard("FC123462");
        fakeCetExamPortal.downloadRankCard("FC123463");
        fakeCetExamPortal.downloadRankCard("FC123464");
        fakeCetExamPortal.downloadRankCard("FC123465");
        
//      Setting up colleges and branches to the counsling portal
        Admin admin = new Admin();
        
        
//        Creating colleges and branches
        College college1 = new College("JNTUK");
        college1.addBranch("Computer Science", 2, 1, 1, 1);
        college1.addBranch("Electronics", 1, 0, 1, 1);
        
        College college2 = new College("AU");
        college2.addBranch("Mechanical", 2, 1, 0, 0);
        college2.addBranch("Civil", 1, 1, 1, 1);
        
        College college3 = new College("SVU");
        college3.addBranch("Information Technology", 0, 1, 1, 1);
        
        College college4 = new College("SWEC");
        college4.addBranch("Electrical", 1, 0, 1, 0);
        
        College college5 = new College("GVP");
        college5.addBranch("Computer Science", 1, 1, 1, 0);
        
        // Adding to the portal
        admin.addCollege(college1);
        admin.addCollege(college2);
        admin.addCollege(college3);
        admin.addCollege(college4);
        admin.addCollege(college5);
        
//        students logs into the portal by giving his registration number 
        Candidate candidate1=new Candidate("RN123456");
        Candidate candidate2=new Candidate("RN123457");
        Candidate candidate3=new Candidate("RN123458");
        Candidate candidate4=new Candidate("RN123459");
        Candidate candidate5=new Candidate("RN123460");
        Candidate candidate6=new Candidate("RN123461");
        Candidate candidate7=new Candidate("RN123462");
        Candidate candidate8=new Candidate("RN123463");
        Candidate candidate9=new Candidate("RN123464");
        Candidate candidate10=new Candidate("RN123465");
        
//        students verify and confirm the registration form
        candidate1.confirmFields();
        candidate2.confirmFields();
        candidate3.confirmFields();
        candidate4.confirmFields();
        candidate5.confirmFields();
        candidate6.confirmFields();
        candidate7.confirmFields();
        candidate8.confirmFields();
        candidate9.confirmFields();
        candidate10.confirmFields();
        
        

//        students pays the counsling fee to opt web options
        admin.getPaymentForConslingFrom(candidate1);
        admin.getPaymentForConslingFrom(candidate2);
        admin.getPaymentForConslingFrom(candidate3);
        admin.getPaymentForConslingFrom(candidate4);
        admin.getPaymentForConslingFrom(candidate5);
        admin.getPaymentForConslingFrom(candidate6);
        admin.getPaymentForConslingFrom(candidate7);
        admin.getPaymentForConslingFrom(candidate8);
        admin.getPaymentForConslingFrom(candidate9);
        admin.getPaymentForConslingFrom(candidate10);
        
//        students verifies their certificaes by uploading them in portal
        admin.verifyCertificates(candidate1);
        admin.verifyCertificates(candidate2);
        admin.verifyCertificates(candidate3);
        admin.verifyCertificates(candidate4);
        admin.verifyCertificates(candidate5);
        admin.verifyCertificates(candidate6);
        admin.verifyCertificates(candidate7);
        admin.verifyCertificates(candidate8);
        admin.verifyCertificates(candidate9);
        admin.verifyCertificates(candidate10);
        
//        students can view the verification status in the portal
        admin.verificationStatus(candidate1);
        admin.verificationStatus(candidate2);
        admin.verificationStatus(candidate3);
        admin.verificationStatus(candidate4);
        admin.verificationStatus(candidate5);
        admin.verificationStatus(candidate6);
        admin.verificationStatus(candidate7);
        admin.verificationStatus(candidate8);
        admin.verificationStatus(candidate9);
        admin.verificationStatus(candidate10);
        
//        those certificates which are not verified by server will be verified manuallt by management,student has to go to the nearest fakecet centre and get verified
        admin.verifyCertificatesManually();
       

//        students opts weboptions, here to make it simple i put all the students options as same three colleges to show you the rank differnce priority
        for (Candidate candidate : Admin.candidates) {
            candidate.addPreference(1, new Option(college1,"Computer Science"));
            candidate.addPreference(2, new Option(college2,"Civil"));
            candidate.addPreference(3, new Option(college3,"Information Technology"));
        }

//        board starts the allotment
        admin.startAllotment();
        
//        here we have the students vs allotedoptions
        System.out.println(Admin.allotedoptions);
        
        
//        here we have collegewise student details to the college
        admin.collegeStats(college1);
        admin.collegeStats(college2);
        admin.collegeStats(college3);
        admin.collegeStats(college4);
        admin.collegeStats(college5);
	}

	

}
