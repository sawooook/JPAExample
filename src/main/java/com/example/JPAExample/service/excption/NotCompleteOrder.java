package com.example.JPAExample.service.excption;

public class NotCompleteOrder extends RuntimeException{
    public NotCompleteOrder() {
        super("Could not write review for order 1 because state(REQUESTED) is not allowed");
    }
}
