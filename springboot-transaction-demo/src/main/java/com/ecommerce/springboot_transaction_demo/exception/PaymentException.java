package com.ecommerce.springboot_transaction_demo.exception;

public class PaymentException extends RuntimeException{

    public PaymentException (String message){
        super(message);
    }

}
