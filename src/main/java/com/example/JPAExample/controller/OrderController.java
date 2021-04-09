package com.example.JPAExample.controller;


import com.example.JPAExample.domain.Order;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import com.example.JPAExample.service.OrderService;
import com.example.JPAExample.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{id}/review")
    public ApiUtils.ApiResult<ReviewResponseDto> writeReview(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long id) {
        Order order = orderService.findByOrder(id);
        ReviewResponseDto response = orderService.writeReview(order, reviewRequestDto);
        return ApiUtils.success(response);
    }
}
