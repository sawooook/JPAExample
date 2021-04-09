package com.example.JPAExample.controller;


import com.example.JPAExample.domain.Order;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import com.example.JPAExample.service.OrderService;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.JPAExample.utils.ApiUtils.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/{id}/review")
    public ResponseEntity<ApiResult<ReviewResponseDto>> writeReview(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long id) {
        Order order = orderService.findByOrder(id);
        ReviewResponseDto response = orderService.writeReview(order, reviewRequestDto);
        ApiResult<ReviewResponseDto> success = success(response);
        return ResponseEntity.ok().body(success);
    }

    public ResponseEntity<>
}
