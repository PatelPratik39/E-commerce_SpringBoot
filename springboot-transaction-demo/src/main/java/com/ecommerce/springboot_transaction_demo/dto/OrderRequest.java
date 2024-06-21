package com.ecommerce.springboot_transaction_demo.dto;

import com.ecommerce.springboot_transaction_demo.entity.Order;
import com.ecommerce.springboot_transaction_demo.entity.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;

}
