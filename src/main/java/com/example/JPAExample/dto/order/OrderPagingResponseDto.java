package com.example.JPAExample.dto.order;

import com.example.JPAExample.domain.etc.OrderState;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class OrderPagingResponseDto {
    private Long seq;
    private Long productId;
    private ReviewResponseDto review;
    private OrderState state;
    private String requestMessage;
    private String rejectMessage;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private LocalDateTime createAt;

    public OrderPagingResponseDto(Long seq, Long productId, ReviewResponseDto review, OrderState orderState,
                                  String requestMessage, String rejectMessage, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createAt) {
        this.seq = seq;
        this.productId = productId;
        this.review = review;
        this.state = orderState;
        this.requestMessage = requestMessage;
        this.rejectMessage = rejectMessage;
        this.completedAt = completedAt;
        this.rejectedAt = rejectedAt;
        this.createAt = createAt;
    }
}
