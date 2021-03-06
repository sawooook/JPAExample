package com.example.JPAExample.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequestDto {
    private Long id;
    private String email;
    private String password;

    public LoginRequestDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
