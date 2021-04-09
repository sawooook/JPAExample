package com.example.JPAExample.domain;

import com.example.JPAExample.domain.etc.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "product_seq")
    private Long id;

    @NotNull
    @Column(length = 50)
    private String name;

    @Column(columnDefinition = "varchar(1000)")
    private String details;

    @Column(name = "review_count")
    private int reviewCount;

    @OneToMany(mappedBy = "product")
    private List<Order> orderList = new ArrayList<>();



}
