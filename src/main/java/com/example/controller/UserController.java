package com.example.controller;

import com.example.dto.LoginRequestDto;
import com.example.utils.ApiUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.utils.ApiUtils.*;

@RestController
@RequestMapping("api/users")
public class UserController {


    @PostMapping("/login")
    public ApiResult<LoginRequestDto> login(@RequestBody LoginRequestDto loginRequestDto) {

    }
}
