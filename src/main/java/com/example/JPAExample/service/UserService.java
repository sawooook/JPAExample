package com.example.JPAExample.service;

import com.example.JPAExample.domain.User;
import com.example.JPAExample.dto.user.LoginRequestDto;
import com.example.JPAExample.dto.user.LoginResponseDto;
import com.example.JPAExample.dto.user.SignUpRequestDto;
import com.example.JPAExample.dto.user.UserResponseDto;
import com.example.JPAExample.repository.UserRepository;
import com.example.JPAExample.service.excption.NotFoundUserException;
import com.example.JPAExample.service.excption.WrongPasswordExcption;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

//    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Long userId = loginRequestDto.getId();
        String userPassword = loginRequestDto.getPassword();
        User findUser = userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);

        if (!isSamePassword(userPassword, findUser.getPassword())) {
            throw new WrongPasswordExcption();
        }
//        String token = jwtService.generateToken(userId);
        String token = "123";

        return new LoginResponseDto(token,
                new UserResponseDto(findUser.getName(), findUser.getEmail(), findUser.getLoginCount(), findUser.getLastLoginAt(), findUser.getLastLoginAt()));
    }

    private boolean isSamePassword(String userPassword, String password) {
        return passwordEncoder.matches(userPassword, password);
    }

    public void save(SignUpRequestDto signUpRequestDto) {

        User user = new User(signUpRequestDto.getName(), signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
        user.lastLoginUpdate();
        userRepository.save(user);
    }
}
