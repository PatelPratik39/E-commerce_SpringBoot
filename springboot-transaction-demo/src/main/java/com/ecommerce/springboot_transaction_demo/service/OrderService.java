package com.ecommerce.springboot_transaction_demo.service;

import com.ecommerce.springboot_transaction_demo.dto.OrderRequest;
import com.ecommerce.springboot_transaction_demo.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

}
