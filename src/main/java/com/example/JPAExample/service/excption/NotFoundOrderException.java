package com.example.JPAExample.service.excption;

public class NotFoundOrderException extends RuntimeException {
    public NotFoundOrderException() {
        super("존재하지 않는 주문입니다.");
    }
}
