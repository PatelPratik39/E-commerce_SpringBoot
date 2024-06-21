package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void saveMethod(){
//        create Product
        Product product = new Product();
        product.setName("product1");
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

//    to test Update method

    @Test
    void updateUsingSaveMethod(){

//        find and retrieve an entity by id
        Long id = 4L;
        Product product = productRepository.findById(id).get();

//        update entity
        product.setName("updated Product 4");
        product.setDescription("Updated Product 4 description");

//        save updated entity to a database
        productRepository.save(product);

    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAll() {
//        create Product
        Product product1 = new Product();
        product1.setName("product 1");
        product1.setDescription("Product 1 description");
        product1.setSku("200ABC");
        product1.setPrice(new BigDecimal(19.99));
        product1.setActive(false);
        product1.setImageUrl("product1.png");


        //        create Product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("100ABC");
        product2.setPrice(new BigDecimal(29.99));
        product2.setActive(false);
        product2.setImageUrl("product2.png");


        //        create Product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(39.99));
        product3.setActive(false);
        product3.setImageUrl("product3.png");


//        save Product
         List<Product> savedProducts = productRepository.saveAll(List.of(product1, product2, product3));
//
//        verify the save operation
        assertNotNull(savedProducts);
        assertEquals(3, savedProducts.size());
    }
//     FindAll()
    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

//        verify that the list is not empty
        assertFalse(products.isEmpty(), "The Products List should not be empty!");
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
         Long id= 10L;
         productRepository.deleteById(id);

    }

    @Test
    void deleteMethod(){
//        find an enetity by Id
        Long id = 11L;
        Product product =productRepository.findById(id).get();

//        delete entity
        productRepository.delete(product);
    }

//    deleteAll
//    @Test
//    void deleteAllMethod(){
//        productRepository.deleteAll();
//    }

//    deleteALl methid using specific parameter
    @Test
    void deleteAllMethod(){
        Product product1 = productRepository.findById(6L).get();
        Product product2 = productRepository.findById(7L).get();
        Product product3 = productRepository.findById(8L).get();

        productRepository.deleteAll(List.of(product1,product2,product3));
    }

    @Test
    void countMehtod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        Long id = 2L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}