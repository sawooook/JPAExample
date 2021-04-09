package com.example.JPAExample.service.excption;

public class DuplicatedReviewException extends RuntimeException {
    public DuplicatedReviewException() {
    }

    public DuplicatedReviewException(String message) {
        super(message);
    }

    public DuplicatedReviewException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedReviewException(Throwable cause) {
        super(cause);
    }

    public DuplicatedReviewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
