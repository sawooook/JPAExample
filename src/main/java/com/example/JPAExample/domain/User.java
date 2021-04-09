package com.example.JPAExample.domain;

import com.example.JPAExample.domain.etc.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.*;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq")
    private Long id;

    private String name;

    private String email;

    @Column(name = "passwd")
    private String password;

    @Column(name = "login_count", columnDefinition =  "integer default 0")
    private Integer loginCount;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();


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
