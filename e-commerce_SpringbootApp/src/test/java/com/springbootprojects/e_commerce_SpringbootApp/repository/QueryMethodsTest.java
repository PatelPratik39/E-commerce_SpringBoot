package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(80));
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(70));
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            System.out.println(product.getActive());
        });
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product 7");
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });

    }
    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("%product%");
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(70), new BigDecimal(90));
        products.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByDateCreatedBetweenmethod(){

//          Start Date
        LocalDateTime startDate = LocalDateTime.of(2024, 6, 19, 0, 0);

        // End Date
        LocalDateTime endDate = LocalDateTime.of(2024, 6, 21, 0, 0);
        List<Product> products =  productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        } );
    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product 6", "product 7", "product 8"));
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        } );
    }

    @Test
    void findFirst6ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst6ByOrderByNameAsc();
        products.forEach((product) -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        } );
    }
}
