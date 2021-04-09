package com.example.JPAExample.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserResponseDto {
    private String name;
    private String email;
    private int loginCount;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createdAt;

    public UserResponseDto(String name, String email, int loginCount, LocalDateTime lastLoginAt, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.loginCount = loginCount;
        this.lastLoginAt = lastLoginAt;
        this.createdAt = createdAt;
    }
}
