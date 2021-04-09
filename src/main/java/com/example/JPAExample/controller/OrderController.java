package com.example.JPAExample.controller;


import com.example.JPAExample.domain.Order;
import com.example.JPAExample.domain.User;
import com.example.JPAExample.dto.order.OrderPagingResponseDto;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.example.JPAExample.dto.review.ReviewResponseDto;
import com.example.JPAExample.service.OrderService;
import com.example.JPAExample.service.UserService;
import com.example.JPAExample.utils.ApiUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.JPAExample.utils.ApiUtils.*;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @PostMapping(value = "/{id}/review")
    public ResponseEntity<ApiResult<ReviewResponseDto>> writeReview(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long id) {
        Order order = orderService.findByOrder(id);
        ReviewResponseDto response = orderService.writeReview(order, reviewRequestDto);
        ApiResult<ReviewResponseDto> success = success(response);
        return ResponseEntity.ok().body(success);
    }

    /*
    * Get으로 받을때 @RequestParam으로 받을것
    *
    * */
    @GetMapping
    public ResponseEntity findAllOrderList(Pageable pageable) {
//        User user = userService.findOne(1L);
        List<OrderPagingResponseDto> orderList = orderService.findOrderList(pageable);
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity userOrderList(@PathVariable Long id) {
        OrderPagingResponseDto orders = orderService.findByUserOrderList(id);

        ApiResult<OrderPagingResponseDto> success = success(orders);

        return ResponseEntity.ok().body(success);
    }
}
