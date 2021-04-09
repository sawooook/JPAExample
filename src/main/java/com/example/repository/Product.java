package com.example.repository;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Product {
    private Long id;
    private String name;
    private String details;
    private int reviewCount;
}
