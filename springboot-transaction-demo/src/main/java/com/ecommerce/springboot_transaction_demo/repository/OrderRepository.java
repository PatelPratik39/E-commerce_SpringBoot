package com.ecommerce.springboot_transaction_demo.repository;

import com.ecommerce.springboot_transaction_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
