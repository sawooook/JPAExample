package com.example.JPAExample.domain;

import com.example.JPAExample.domain.Product;
import com.example.JPAExample.domain.etc.BaseEntity;
import com.example.JPAExample.domain.etc.OrderState;
import com.example.JPAExample.dto.review.ReviewRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_seq")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_seq")
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy = "order")
    private List<Review> reviewList = new ArrayList<>();

    @Column(name = "review_seq")
    private Integer reviewSeq;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "request_msg")
    private String requestMsg;

    @Column(name = "reject_msg")
    private String rejectMsg;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "rejected_at")
    private LocalDateTime rejectedAt;

    public void updateReviewCount() {
        this.reviewSeq += 1;
    }
}
