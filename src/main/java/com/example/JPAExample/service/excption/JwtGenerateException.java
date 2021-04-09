package com.example.JPAExample.service.excption;

public class JwtGenerateException extends RuntimeException {
    public JwtGenerateException() {
    }

    public JwtGenerateException(String message) {
        super(message);
    }

    public JwtGenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public JwtGenerateException(Throwable cause) {
        super(cause);
    }

    public JwtGenerateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
