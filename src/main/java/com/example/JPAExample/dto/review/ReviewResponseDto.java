package com.example.JPAExample.dto.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ReviewResponseDto {
    private Long seq;
    private Long productId;
    private String content;
    private LocalDateTime createdAt;

    public ReviewResponseDto(Long seq, Long productId, String content, LocalDateTime createdAt) {
        this.seq = seq;
        this.productId = productId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
