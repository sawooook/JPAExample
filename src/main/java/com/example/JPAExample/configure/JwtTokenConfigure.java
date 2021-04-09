package com.example.JPAExample.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class JwtTokenConfigure {
    private String header;
    private String issuer;
    private String clientSecret;
    private int expireSeconds;
}
