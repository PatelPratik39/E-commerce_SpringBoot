package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product 6");

        System.out.println(product.getName());
        System.out.println(product.getId());
        System.out.println(product.getDescription());
    }

    @Test
    void findById() {
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescription() {
        List<Product> products = productRepository.findByNameOrDescription("product 6", "product 6 description");
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }
    @Test
    void findByNameAndDescription() {
        List<Product> products = productRepository.findByNameAndDescription("product 6", "product 6 description");
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }

    @Test
    void findDistinctByName(){

        Product product = productRepository.findDistinctByName("product 6");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
    @Test
    void findByPriceGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(80));
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }

    @Test
    void findByPriceLessThan(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(70));
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }
}
