package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueryTest {

    @Autowired
    private ProductRepository productRepository;

//    @Test
//    void namedJPQLQuery(){
//        Product product = productRepository.findByPrice(new BigDecimal("100"));
//        System.out.println(product.getName());
//        System.out.println(product.getDescription());
//    }

    @Test
    void namedQueryTest() {
//        Print all products from Entity
        productRepository.findAll().forEach(System.out::println);

        Product product = productRepository.findByPrice(new BigDecimal("69.99 "));
        if(product != null){
            System.out.println(product.getName());
            System.out.println(product.getDescription());
        } else {
            System.out.println("Product not Found!!!");
        }
    }

    @Test
    void namedJPQLQueries(){

        List<Product> products = productRepository.findAllOrderByNameDesc();

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });

        Product product = productRepository.findByPrice(new BigDecimal("69.99"));
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedNativeSQLQuery(){
        Product product = productRepository.findByDescription("Product 1 description");
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void namedNativeSQLQueries(){
        Product product = productRepository.findByDescription("product 6 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());

        List<Product> products = productRepository.findAllOrderByNameASC();

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getDescription());
        });
    }


}
