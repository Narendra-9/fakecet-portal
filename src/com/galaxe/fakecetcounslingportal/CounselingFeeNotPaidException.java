package com.galaxe.fakecetcounslingportal;

@SuppressWarnings("serial")
class CounselingFeeNotPaidException extends Exception {
    public CounselingFeeNotPaidException(String message) {
        super(message);
    }
}