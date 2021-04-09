package com.example.JPAExample.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;

    public SignUpRequestDto() {
    }

    public SignUpRequestDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
