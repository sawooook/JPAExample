package com.example.JPAExample.domain;

import com.example.JPAExample.domain.etc.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_seq")
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_seq")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_seq")
    private Order order;

    @Column(length = 1000)
    private String content;


    public Review(User user, Product product, Order order, String content) {
        this(null, user, product, order, content);
    }

    public Review(Long id, User user, Product product, Order order, String content) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.order = order;
        this.content = content;
    }
}
