package com.example.JPAExample.controller;

import com.example.JPAExample.dto.user.LoginRequestDto;
import com.example.JPAExample.dto.user.LoginResponseDto;
import com.example.JPAExample.dto.user.SignUpRequestDto;
import com.example.JPAExample.service.JwtService;
import com.example.JPAExample.service.UserService;
import com.example.JPAExample.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Validated @RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto response = userService.login(loginRequestDto);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ApiUtils.ApiResult<SignUpRequestDto> signUp(@Validated @RequestBody SignUpRequestDto signUpRequestDto) {
        userService.save(signUpRequestDto);
        return ApiUtils.success(null);
    }
}
