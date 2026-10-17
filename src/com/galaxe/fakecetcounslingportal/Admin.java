package com.galaxe.fakecetcounslingportal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.galaxe.fakecetexamportal.FakeCetExamPortal;

public class Admin implements FakeCetCounslingPortal{
	
	
	public static List<Candidate> candidates;
	public static Map<Candidate,Option> allotedoptions;
	private List<College> colleges;
	
	public Admin() {
        this.colleges = new ArrayList<>();
        allotedoptions=new HashMap<>();
        candidates=new ArrayList<Candidate>();
    }

    public void addCollege(College college) {
        colleges.add(college);
    }

    public List<College> getColleges() {
        return colleges;
    }
    
    public void getPaymentForConslingFrom(Candidate student) {
    	if(student.isFieldsConfirmed()) {
    		student.setCounslingPaymentDetails(new CounslingPaymentDetails("CPT"+student.getAcademicDetails().getInterHallticketNumber().substring(3), 1200, LocalDate.now()));
    		System.out.println("Payment successful");
    		candidates.add(student);
    		System.out.println("PaymentReferenceId : "+student.getCounslingPaymentDetails().getPaymentReferenceId());
    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		System.out.println(student.getPersonalDetails().getStudentName()+" registered for counsling successfully ");
    		System.out.println("Verify your certificates and Give your Weboptions\n");
    		
    	}
    }
    
    public void verifyCertificates(Candidate student) throws Exception {
    	if(candidates.contains(student)) {
    		Random rand=new Random();
        	if(rand.nextBoolean()) {
        		student.verifiedCertificates();
        	}	
    	}
    	else{
    		throw new Exception("Pay the counsling fee and then verify your certificates ");
    	}
    }
    
    public void verificationStatus(Candidate student) throws Exception {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	if(candidates.contains(student)) {
    		if(student.isCertificatesVerified()) {
        		System.out.println(student.getPersonalDetails().getStudentName()+"'s Certificates are approved,Candidate is good to apply for colleges");
        	}
        	else {
        		System.out.println(student.getPersonalDetails().getStudentName()+", reach the nearest FakeCet centre to verify your certificates manually !");
        	}
    	}
    	else {
    		throw new Exception("Pay the counsling fee and then verify your certificates ");

    	}
    	
    }
    
    public void verifyCertificatesManually() {
        try (Scanner sc = new Scanner(System.in)) {
            candidates.stream()
                	  .filter(i -> !i.isCertificatesVerified())
                      .forEach(i -> {
                    System.out.println("\nDo you want to approve " + i.getPersonalDetails().getStudentName() + "'s certificates?");
                    String flag = sc.nextLine();  
                    if (flag.equalsIgnoreCase("Yes")) { 
                        System.out.println(i.getPersonalDetails().getStudentName() + "'s certificates verified manually. Candidate is good to go and can apply to colleges.");
                        i.verifiedCertificates();
                    } else {
                        System.out.println(i.getPersonalDetails().getStudentName() + "'s certificates are not appropriate; they can't apply for counseling.");
                    }
                      });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nRemoving the candidates whoose certificates are inappropriate  -------");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        candidates.removeAll(candidates.stream().filter(i->!i.isCertificatesVerified()).collect(Collectors.toList()));
        System.out.println("After removing the system consists of : "+candidates);
    }

	
    @Override
    public void startAllotment() {
        System.out.println("Starting allotment process...");
        Admin.candidates.sort((i, j) -> (int) (FakeCetExamPortal.results.stream()
        																.filter(k->k.getHallticketNumber()==i.getHallticket().getHallticketnumber())
        																.findFirst()
        																.orElse(null)
        																.getRank() - FakeCetExamPortal.results.stream()
        																							  .filter(l->l.getHallticketNumber()==j.getHallticket().getHallticketnumber())
        																							  .findFirst()
        																							  .orElse(null)
        																							  .getRank()));
        for (Candidate student : candidates) {
            System.out.println("\nProcessing student: " + student.getPersonalDetails().getStudentName()+"\n");
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            for (Option option : student.optedPreferences.values()) {
                Branch branch = option.getBranch();
                try {
        			Thread.sleep(1000);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
                if (option.getCollege().hasAvailableSeats(branch.getBranchName(), student.getPersonalDetails().getCaste())) {
                    System.out.println(student.getPersonalDetails().getStudentName() + " allocated to " +option.getCollege()+", "+branch.getBranchName());
                    branch.addStudent(student);
                    student.allotedOption = option;
                    allotedoptions.put(student,student.allotedOption);
                    break; // Stop once the student is allotted a branch
                } else {
                    System.out.println("No available seats in " + branch.getBranchName() + " for " + student.getPersonalDetails().getStudentName());
                }
            }
        }
    }
    
    public void collegeStats(College college) {
    	System.out.println("-----------------\nResults for " + college.getCollegeName() + ":");
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        for (Branch branch : college.getBranches().values()) {
            System.out.println("Branch: " + branch.getBranchName());
            System.out.println("Allotted Students: ");
            for (Candidate candidate : branch.getStudents()) {
                System.out.println(" - " + candidate.getPersonalDetails().getStudentName() + " (Rank: " + FakeCetExamPortal.resultsTable.get(candidate.getHallticket().getHallticketnumber()).getRank() + ", Caste: " + candidate.getPersonalDetails().getCaste() + ")");
            }
            System.out.println("Available Seats (General): " + branch.getAvailableSeats("General"));
            System.out.println("Available Seats (SC): " + branch.getAvailableSeats("SC"));
            System.out.println("Available Seats (ST): " + branch.getAvailableSeats("ST"));
        }
    }
		
}
