package com.galaxe.fakecetcounslingportal;

import java.util.ArrayList;
import java.util.List;


public class Branch {
	
    private String branchName;
    private int availableSeatsGeneral;
    private int availableSeatsBC;
    private int availableSeatsSC;
    private int availableSeatsST;
    private List<Candidate> students; // List of students in this branch

    public Branch(String branchName, int availableSeatsGeneral,int availableSeatssBC, int availableSeatsSC, int availableSeatsST) {
        this.branchName = branchName;
        this.availableSeatsGeneral = availableSeatsGeneral;
        this.availableSeatsBC=availableSeatssBC;
        this.availableSeatsSC = availableSeatsSC;
        this.availableSeatsST = availableSeatsST;
        this.students = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public int getAvailableSeats(String caste) {
        int availableSeats=switch (caste) {
        	case "BC"->availableSeatsBC;
            case "SC"->availableSeatsSC;
            case "ST"->availableSeatsST;
            default->availableSeatsGeneral;
        };
        return availableSeats;
    }

    public void addStudent(Candidate student) {
        String caste = student.getPersonalDetails().getCaste();
        if (caste.equals("SC") && availableSeatsSC > 0) {
            students.add(student);
            availableSeatsSC--; // Decrease the available SC seats
        } else if (caste.equals("ST") && availableSeatsST > 0) {
            students.add(student);
            availableSeatsST--; // Decrease the available ST seats
        } else if (caste.equals("BC") && availableSeatsBC > 0) {
            students.add(student);
            availableSeatsBC--; // Decrease the available general seats
        }	else if (availableSeatsGeneral > 0) {
            students.add(student);
            availableSeatsGeneral--; // Decrease the available general seats
        }
    }

    public List<Candidate> getStudents() {
        return students;
    }

	@Override
	public String toString() {
		return  branchName ;
	}
    
    
}
