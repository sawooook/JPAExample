package com.example.JPAExample.service.excption;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super("존재하지 않는 유저입니다.");
    }
}
