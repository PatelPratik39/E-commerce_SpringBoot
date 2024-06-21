package com.ecommerce.springboot_transaction_demo.dto;


import lombok.Data;

@Data
public class OrderResponse {

    private String orderTrackingNumber;
    private String status;
    private String message;
}
