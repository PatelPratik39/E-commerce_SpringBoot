package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void saveMethod(){

//        create Product

        Product product = new Product();
        product.setProductName("product1");
        product.setDescription("Product1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100.99));
        product.setActive(true);
        product.setImageUrl("product1.png");

//        save Product
        Product savedProduct = productRepository.save(product);


//        display Product Info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

}