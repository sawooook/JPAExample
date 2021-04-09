package com.example.JPAExample.controller;

import com.example.JPAExample.dto.user.LoginRequestDto;
import com.example.JPAExample.service.UserService;
import com.example.JPAExample.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/login")
    public ApiUtils.ApiResult<LoginRequestDto> login(@Validated @RequestBody LoginRequestDto loginRequestDto) {

        userService.login(loginRequestDto);

        return ApiUtils.success(loginRequestDto);

    }
}
