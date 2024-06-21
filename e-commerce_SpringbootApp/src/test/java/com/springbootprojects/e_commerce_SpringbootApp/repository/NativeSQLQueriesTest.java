package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private  ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParam(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("product 6", "product 6 description");
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod() {
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("product 8", "product 8 description");

        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
