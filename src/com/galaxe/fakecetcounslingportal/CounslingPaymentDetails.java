package com.galaxe.fakecetcounslingportal;

import java.time.LocalDate;


public class CounslingPaymentDetails{
	

	private final String paymentReferenceId;
	private	final double amount;
	private final LocalDate dateOfPayment;
	
	public CounslingPaymentDetails(String paymentReferenceId, double amount, LocalDate dateOfPayment) {
		this.paymentReferenceId = paymentReferenceId;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
	}


	public String getPaymentReferenceId() {
		return paymentReferenceId;
	}


	public double getAmount() {
		return amount;
	}



	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}


	@Override
	public String toString() {
		return "paymentReferenceId : " + paymentReferenceId + ", amount : " + amount
				+ ", dateOfPayment : " + dateOfPayment;
	}

	
	
}