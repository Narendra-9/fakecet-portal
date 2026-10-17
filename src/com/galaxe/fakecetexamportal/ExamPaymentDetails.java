package com.galaxe.fakecetexamportal;

import java.time.LocalDate;

public final class ExamPaymentDetails {
    
    private final String paymentReferenceId;
    private final double amount;
    private final LocalDate dateOfPayment;

    public ExamPaymentDetails(String paymentReferenceId, double amount, LocalDate dateOfPayment) {
        if (paymentReferenceId == null || paymentReferenceId.isEmpty()) {
            throw new IllegalArgumentException("Payment reference ID cannot be null or empty.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        if (dateOfPayment == null) {
            throw new IllegalArgumentException("Date of payment cannot be null.");
        }
        
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

}
