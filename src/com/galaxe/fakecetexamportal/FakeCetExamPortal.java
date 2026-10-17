package com.galaxe.fakecetexamportal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FakeCetExamPortal implements FakeCetExamPortalManagement{
	
	private boolean examConducted=false;
	private Map<String,String> centres;
	public static List<Student> students;
	public static Map<String,Hallticket> halltickets;
	public static Map<String,Exam> resultsTable;
	public static List<Exam> results;
	
	public static boolean isready = false;
	
	public FakeCetExamPortal() {
		
		isready=true;
		System.out.println("The Site is ready !\n");
		this.centres=new HashMap<>();
		resultsTable=new HashMap<>();
		students=new ArrayList<>();
		halltickets=new HashMap<>();
		results=new ArrayList<>();
		centres.put("Kakinada", "ION Digital,Achuthapuram");
		centres.put("Bhimavaram", "SRKR College");
		centres.put("Rajahmundry", "Rajeev Gandhi,ION Digital zone Luthergiri");
	}

	@Override
	public void getPaymentforExamfrom(Student student) {
		if(student.getAcademicDetails()==null ) {
			System.out.println("Your Academic details are empty !");
		}
		else if(student.getPersonalDetails()==null) {
			System.out.println("Your Personal details are empty !");

		}
		else {
			student.setPaymentDetails(new ExamPaymentDetails("PT"+(student.getAcademicDetails().getInterHallticketNumber()).substring(2), 500, LocalDate.now()));
			student.setRegistrationId("RN"+(student.getAcademicDetails().getInterHallticketNumber()).substring(2));
			students.add(student);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\nPayment Succesfull");
			System.out.println("PaymentReferenceId : "+student.getPaymentDetails().getPaymentReferenceId());
			System.out.println("Application Form Submitted !");
			System.out.println("Registration Id :"+student.getRegistrationId());
			student.displayStudentDetails();
			
		}
	}

	@Override
	public void releaseHalltickets() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		students.stream().forEach(i->halltickets.put(i.getRegistrationId(),new Hallticket("FC"+(i.getAcademicDetails().getInterHallticketNumber()).substring(2),i.getPersonalDetails().getStudentName(),centres.get(i.getPersonalDetails().getCity()), LocalDate.of(2024,10,5)) ));
		System.out.println("\n-----Hallticekts released by Board-----");
	}
	
	@Override
    public void downloadHallticket(String registrationId) {
        Hallticket hallticket = halltickets.get(registrationId);
        String filePath=".\\Halltickets\\" + hallticket.getCandidateName() + ".txt";
        Student student = students.stream()
            .filter(i -> i.getRegistrationId().equals(registrationId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No student found with registration ID: " + registrationId));

        student.setHallticket(hallticket);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Hallticket numer : "+hallticket.getHallticketnumber() + "\nCandiddate Name : " + hallticket.getCandidateName() + "\nExam Centre : " + hallticket.getExamcentre() + "\nExam Date : " + hallticket.getDateOfExam());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nHallticket Downloaded !");
    }


	@Override
	public void conductExam() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setExamConducted(true);
	}

	@Override
	public void takeAttendence(String hallTicketNumber) {
		if(this.examConducted) {
			students.stream().filter(i->i.getHallticket().getHallticketnumber().equals(hallTicketNumber))
							 .findFirst()
							 .orElse(null)
							 .setExamAttended(true);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			students.stream().filter(i->i.getHallticket().getHallticketnumber().equals(hallTicketNumber))
			 				 .forEach(i->System.out.println("\n"+i.getPersonalDetails().getStudentName()+" took the Exam"));
		}
		else {
			System.out.println("Exam not conducted !");
		}
		
	}

	@Override
	public void publishResults() {
		
		Random rand=new Random();
		students.stream().filter(i->i.isExamAttended()).forEach(i->{
//			If the student is from sc/St i am giving less marks just to show my code is working according to category,nothing else
			if(i.getPersonalDetails().getCaste()=="SC" || i.getPersonalDetails().getCaste()=="ST") {
				int math=rand.nextInt(40);
				int phy=rand.nextInt(20);
				int chem=rand.nextInt(20);
				results.add(new Exam(i.getHallticket().getHallticketnumber(),math,phy,chem));

			}
			else {

				int math=rand.nextInt(40)+40;
				int phy=rand.nextInt(20)+20;
				int chem=rand.nextInt(20)+20;
				results.add(new Exam(i.getHallticket().getHallticketnumber(),math,phy,chem));

			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		results.sort((i,j)->{
    		if(i.getTotalMarks()!=j.getTotalMarks()) {
    			return j.getTotalMarks()-i.getTotalMarks();
    		}
    		else if(i.getMathsMarks()!=j.getMathsMarks()) {
    			return j.getMathsMarks()-i.getMathsMarks();
    		}
    		else if(i.getMathsMarks()!=j.getMathsMarks()){
    			return j.getMathsMarks()-i.getMathsMarks();
    		}
    		else if(i.getPhysicsMarks()!=j.getPhysicsMarks()) {
    			return j.getPhysicsMarks()-i.getPhysicsMarks();
    		}
    		else if(i.getChemistryMarks()!=j.getChemistryMarks()) {
    			return j.getChemistryMarks()-i.getChemistryMarks();
    		}
    		else {
    			return students.stream().filter(l->l.getHallticket().getHallticketnumber()==i.getHallticketNumber())
    							 .findFirst()
    							 .orElse(null)
    							 .getPersonalDetails()
    							 .getStudentName()
    							 .compareTo(students.stream().filter(k->k.getHallticket().getHallticketnumber()==i.getHallticketNumber())
    									 			.findFirst()
    									 			.orElse(null)
    									 			.getPersonalDetails()
    									 			.getStudentName());
    		}
		});
		
		for(int i=0;i<results.size();i++) {
			results.get(i).setRank(i+1);
		}
		
		results.stream().forEach(i->{
			resultsTable.put(i.getHallticketNumber(), i);
		});
		
		System.out.println("\n-----Results published by board-----");
		
	}

	@Override
	public void viewResult(String hallticketNumber) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = students.stream().filter(i->i.getHallticket().getHallticketnumber().equals(hallticketNumber))
									   .findFirst()
									   .orElse(null)
									   .getPersonalDetails()
									   .getStudentName();
		System.out.println("\nResult of "+name+" : ");
		results.stream().filter(i->i.getHallticketNumber().equals(hallticketNumber)).forEach(System.out::print);
		
	}
	


	@Override
	public void downloadRankCard(String hallticketNumber) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = students.stream().filter(i->i.getHallticket().getHallticketnumber().equals(hallticketNumber))
				   .findFirst()
				   .orElse(null)
				   .getPersonalDetails()
				   .getStudentName();
		Exam result=results.stream().filter(i->i.getHallticketNumber().equals(hallticketNumber)).findFirst().orElse(null);
        String filePath2=".\\RankCards\\" +name+"_"+hallticketNumber+ ".txt";
		try(BufferedWriter br=new BufferedWriter(new FileWriter(filePath2))){
			br.write("Name : "+name);
			br.newLine();
			br.write("MathsMark : "+result.getMathsMarks());
			br.newLine();
			br.write("PhysicsMark : "+result.getPhysicsMarks());
			br.newLine();
			br.write("ChemistryMark : "+result.getChemistryMarks());
			br.newLine();
			br.write("TotalMark : "+result.getTotalMarks());
			br.newLine();
			br.write("Rank :"+result.getRank());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nRankCard Downloaded !");
		
	}

	public boolean isExamConducted() {
		return examConducted;
	}

	public void setExamConducted(boolean examConducted) {
		this.examConducted = examConducted;
	}
	

}
