package com.example.JPAExample.service.excption;

public class WrongPasswordExcption extends RuntimeException {
    public WrongPasswordExcption() {
        super("잘못된 비밀번호입니다.");
    }
}
