package com.example.JPAExample.domain.etc;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

import static com.google.common.base.Preconditions.*;

@Getter
public class Email {
    private String address;

    public Email(String address) {
        checkArgument(StringUtils.isEmpty(address), "주소가 없습니다");
        checkArgument(
                address.length() >= 10 && address.length() <= 50,
                "주소는 최소 10자에서 50자 사이에 있어야합니다."
        );
        checkArgument(checkAddress(address), "유효하지 않은 주소입니다.");
        this.address = address;
    }

    private boolean checkAddress(String address) {
        return Pattern.matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", address);
    }
}
