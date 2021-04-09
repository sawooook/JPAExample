package com.example.JPAExample.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginResponseDto {
    private String token;
    private UserResponseDto user;

    public LoginResponseDto(String token, UserResponseDto user) {
        this.token = token;
        this.user = user;
    }
}
