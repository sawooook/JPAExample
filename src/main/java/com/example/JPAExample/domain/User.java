package com.example.JPAExample.domain;

import com.example.JPAExample.domain.etc.BaseEntity;
import com.example.JPAExample.domain.etc.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.*;

@Entity
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String password;
    private int loginCount;
    private LocalDateTime lastLoginAt;

    public User() {
    }

    public User(String name, String email, String password) {
        this(null, name, email, password, 0);
    }

    public User(Long id, String name, String email, String password, int loginCount) {
        checkValid(name, password);
        checkNotNull(email, "이메일은 반드시 입력되어야합니다");
        checkNotNull(password, "비밀번호는 반드시 입력되어야합니다.");
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.loginCount = loginCount;
        this.lastLoginAt = LocalDateTime.now();
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
        lastLoginAt = LocalDateTime.now();
    }

}
