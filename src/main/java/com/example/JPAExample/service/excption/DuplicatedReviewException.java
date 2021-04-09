package com.example.JPAExample.service.excption;

public class DuplicatedReviewException extends RuntimeException {
    public DuplicatedReviewException() {
        super("DuplicatedReviewException");
    }
}
