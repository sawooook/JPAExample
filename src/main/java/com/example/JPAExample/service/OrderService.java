package com.example.JPAExample.service;


import com.example.JPAExample.domain.Order;
import com.example.JPAExample.domain.Review;
import com.example.JPAExample.domain.etc.OrderState;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import com.example.JPAExample.repository.OrderRepository;
import com.example.JPAExample.repository.ReviewRepository;
import com.example.JPAExample.service.excption.DuplicatedReviewException;
import com.example.JPAExample.service.excption.NotCompleteOrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ReviewRepository reviewRepository;

    public Order findByOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(NotCompleteOrderException::new);
        return order;
    }

    public ReviewResponseDto writeReview(Order order, ReviewRequestDto reviewRequestDto) {

        // 주문을 완료 하지 않았을 경우
        if (isNotCompleteOrder(order.getState())) {
            throw new NotCompleteOrderException("Could not write review for order 1 because state(REQUESTED) is not allowed");
        }

        // 이미 리뷰를 작성한 상태
        if (order.getReviewSeq() == 1) {
            throw new DuplicatedReviewException("Could not write review for order 4 because have already written");
        }

        Review review = new Review(order.getUser(), order.getProduct(), order, reviewRequestDto.getContent());
        reviewRepository.save(review);
        order.updateReviewCount();

        return new ReviewResponseDto(review.getId(),review.getProduct().getId(), review.getContent(), review.getCreatedAt());
    }

    private boolean isNotCompleteOrder(OrderState state) {
        return state != OrderState.COMPLETED;
    }
}
