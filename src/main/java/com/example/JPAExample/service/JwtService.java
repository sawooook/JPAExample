package com.example.JPAExample.service;

import com.example.JPAExample.service.excption.JwtGenerateException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtService {
    private static final String SECRET = "sawoook_secret_key";
    private static final String CHARSET = "UTF-8";
    private static final String PREFIX = "Bearer ";


    public String generateToken(Long userid) {
        try {
            return Jwts.builder()
                    .setHeaderParam("typ", "JWT")
                    .setExpiration(new Date(System.currentTimeMillis() + (6 * 60 * 60 * 1000)))
                    .claim("name", userid)
                    .claim("scope", "normal")
                    .signWith(
                            SignatureAlgorithm.HS256,
                            genKey()
                    ).compact();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new JwtGenerateException("지원하지 않는 토큰입니다.");
        }
    }

    private byte[] genKey() throws UnsupportedEncodingException {
        return SECRET.getBytes(CHARSET);
    }
}
