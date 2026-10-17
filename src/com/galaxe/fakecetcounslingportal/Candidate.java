package com.galaxe.fakecetcounslingportal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.galaxe.fakecetexamportal.Student;



public class Candidate extends Student{
	
	private boolean fieldsConfirmed=false;
	private CounslingPaymentDetails counslingPaymentDetails;
	public Option allotedOption; 
    public Map<Integer, Option> optedPreferences; // Use integer to indicate preference order
    private boolean certificatesVerified=false;

    
	public Candidate(String registrationNumber) {
		super(registrationNumber);
		System.out.println(this.getPersonalDetails().getStudentName()+" Logged into Councling portal");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		this.optedPreferences=new HashMap<>();
		System.out.println("\nVerify and confirm the details !");
		super.displayStudentDetails();
	}

	public CounslingPaymentDetails getCounslingPaymentDetails() {
		return counslingPaymentDetails;
	}

	public void setCounslingPaymentDetails(CounslingPaymentDetails counslingPaymentDetails) {
		this.counslingPaymentDetails = counslingPaymentDetails;
	}
	
    public void addPreference(int order, Option option) throws Exception {
    	if(this.counslingPaymentDetails!=null) {
    		if(this.isCertificatesVerified()) {
    			optedPreferences.put(order, option);
    		}
    		else {
    			throw new CertificatesNotApprovedException("Certificates are not accepted");
    		}
    	}else {
    		
    		throw new CounselingFeeNotPaidException("Counsling Fee not paid !");
    	}
      
    }

	public boolean isFieldsConfirmed() {
		return fieldsConfirmed;
	}

	
	public void editName(String name) {
		this.getPersonalDetails().setStudentName(name);
		System.out.println("Student name edited to "+name);
	}
	
	public void editFathersName(String fatherName) {
        this.getPersonalDetails().setFatherName(fatherName);
        System.out.println("Father's name edited to " + fatherName);
    }

    public void editMothersName(String motherName) {
        this.getPersonalDetails().setMotherName(motherName);
        System.out.println("Mother's name edited to " + motherName);
    }

    public void editDateOfBirth(int year,int month,int day) {
        this.getPersonalDetails().setDateofBith(LocalDate.of(year, month, day));
        System.out.println("Date of Birth edited to " + this.getPersonalDetails().getDateofBith());
    }

    public void editAadharNumber(String aadharNumber) {
        this.getPersonalDetails().setAadharnumber(aadharNumber);
        System.out.println("Aadhar number edited to " + aadharNumber);
    }

    public void editCity(String city) {
        this.getPersonalDetails().setCity(city);
        System.out.println("City edited to " + city);
    }

    public void editCaste(String caste) {
        this.getPersonalDetails().setCaste(caste);
        System.out.println("Caste edited to " + caste);
    }
    
    public void confirmFields() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.fieldsConfirmed= true;
		System.out.println("Details are saved for "+this.getRegistrationId());
		System.out.println("Pay the counsling fee to register for counsling\n");
	}

	public boolean isCertificatesVerified() {
		return certificatesVerified;
	}

	public void verifiedCertificates() {
		this.certificatesVerified = true;
	}

	@Override
	public String toString() {
		return "\n(RId: "+this.getRegistrationId()+"|Candidate : "+this.getPersonalDetails().getStudentName()+")";
	}
	
	
}
	