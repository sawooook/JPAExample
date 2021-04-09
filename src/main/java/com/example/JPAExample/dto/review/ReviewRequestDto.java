package com.example.JPAExample.dto.review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ReviewRequestDto {
    private String content;

    public ReviewRequestDto(String content) {
        this.content = content;
    }
}
