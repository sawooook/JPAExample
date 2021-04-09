package com.example.JPAExample.service.excption;

public class NotCompleteOrderException extends RuntimeException {
    public NotCompleteOrderException() {
    }

    public NotCompleteOrderException(String message) {
        super(message);
    }

    public NotCompleteOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCompleteOrderException(Throwable cause) {
        super(cause);
    }

    public NotCompleteOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
