package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("product1", "Product 1 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod() {
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("product 6", "product 6 description");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

}
