package com.example.repository;

import com.example.repository.etc.Email;

import javax.persistence.Entity;

@Entity
public class User {
    private Long id;
    private String name;
    private Email email;
    private String password;
    private int loginCount;

    public User(Long id, String name, Email email, String password, int loginCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.loginCount = loginCount;
    }
}
