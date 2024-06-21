package com.ecommerce.springboot_transaction_demo.service.OrderServiceImpl;

import com.ecommerce.springboot_transaction_demo.dto.OrderRequest;
import com.ecommerce.springboot_transaction_demo.dto.OrderResponse;
import com.ecommerce.springboot_transaction_demo.entity.Order;
import com.ecommerce.springboot_transaction_demo.entity.Payment;
import com.ecommerce.springboot_transaction_demo.exception.PaymentException;
import com.ecommerce.springboot_transaction_demo.repository.OrderRepository;
import com.ecommerce.springboot_transaction_demo.repository.PaymentRepository;
import com.ecommerce.springboot_transaction_demo.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

//    imported two repositories

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

//        created Order
        Order order = orderRequest.getOrder();
//        set the status
        order.setStatus("IN-PROGRESS");
//        set the transaction id using uuid()
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
//      save into repository
        orderRepository.save(order);

//        get order payment from payment repository
        Payment payment = orderRequest.getPayment();

//        if no payments found trow new exception from custom exception class

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment cart type do not support");
        }
//        if payment finds, set into payment using orderId
//        saving into payment repository
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

//        created new order response
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
