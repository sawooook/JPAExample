package com.example.JPAExample.service;


import com.example.JPAExample.domain.Order;
import com.example.JPAExample.domain.Review;
import com.example.JPAExample.domain.User;
import com.example.JPAExample.domain.etc.OrderState;
import com.example.JPAExample.dto.order.OrderPagingResponseDto;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import com.example.JPAExample.repository.OrderRepository;
import com.example.JPAExample.repository.ReviewRepository;
import com.example.JPAExample.service.excption.DuplicatedReviewException;
import com.example.JPAExample.service.excption.NotCompleteOrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<OrderPagingResponseDto> findOrderList(Pageable pageable) {
        PageRequest page = PageRequest.of((int) pageable.getOffset(), pageable.getPageSize(), Sort.Direction.DESC,"id");

        List<Order> content = orderRepository.findAll(page).getContent();
        return makeOrderResponse(content);
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

    public OrderPagingResponseDto findByUserOrderList(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(NotCompleteOrderException::new);

        ReviewResponseDto reviewResponseDto = null;
        if (!order.getReviewList().isEmpty()) {
            reviewResponseDto = new ReviewResponseDto(order.getReviewList().get(0).getId(),
                    order.getReviewList().get(0).getProduct().getId(), order.getReviewList().get(0).getContent(),
                    order.getReviewList().get(0).getCreatedAt());
        }

        return new OrderPagingResponseDto(order.getId(), order.getProduct().getId(), reviewResponseDto, order.getState(), order.getRequestMsg(), order.getRejectMsg(),
                order.getCompletedAt(), order.getRejectedAt(), order.getCreatedAt());
    }

    private List<OrderPagingResponseDto> makeOrderResponse(List<Order> orders) {
        List<OrderPagingResponseDto> response = new ArrayList<>();
        for (Order order : orders) {
            ReviewResponseDto reviewResponseDto = null;
            if (!order.getReviewList().isEmpty()) {
                reviewResponseDto = new ReviewResponseDto(order.getReviewList().get(0).getId(), order.getProduct().getId(), order.getReviewList().get(0).getContent(), order.getReviewList().get(0).getCreatedAt());
            }
            OrderPagingResponseDto result = new OrderPagingResponseDto(order.getId(), order.getProduct().getId(), reviewResponseDto, order.getState(), order.getRequestMsg(),
                    order.getRequestMsg(), order.getCompletedAt(), order.getRejectedAt(), order.getCompletedAt());
            response.add(result);
        }

        return response;
    }
}
