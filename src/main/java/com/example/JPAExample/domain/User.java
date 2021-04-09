package com.example.JPAExample.domain;

import com.example.JPAExample.domain.etc.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private Email email;
    private String password;
    private int loginCount;
    private LocalDateTime lastLoginedAt;

    public User(Long id, String name, Email email, String password, int loginCount) {
        checkValid(name, password);
        checkNotNull(email, "이메일은 반드시 입력되어야합니다");
        checkNotNull(password, "비밀번호는 반드시 입력되어야합니다.");
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.loginCount = loginCount;
    }

    private void checkValid(String name, String password) {
        checkArgument(!StringUtils.isEmpty(name), "이름은 반드시 입력되어야합니다.");
        checkArgument(!StringUtils.isEmpty(password), "비밀번호는 반드시 입력되어야 합니다,");
        checkArgument(
                name.length() >= 1 && name.length() <= 10,
                "이름의 길이는 최소 1자에서 최대 10자 사이여야합니다"
        );
    }

    public void lastLoginUpdate() {
        loginCount += 1;
        lastLoginedAt = LocalDateTime.now();
    }

}
