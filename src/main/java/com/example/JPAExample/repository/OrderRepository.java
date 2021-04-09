package com.example.JPAExample.repository;

import com.example.JPAExample.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.attribute.standard.PageRanges;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);

    Page<Order> findAll(Pageable pageable);
}
