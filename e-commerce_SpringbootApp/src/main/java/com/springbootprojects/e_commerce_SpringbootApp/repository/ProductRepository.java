package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProductRepository  extends JpaRepository<Product, Long> {

//    write query methods
    /*
        if no product entry is found, this will return null;
     */
    public Product findByName(String name);

    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findByNameAndDescription(String name, String description);

//    Query to find a Distinct product or a unique product Method
    public Product findDistinctByName(String name);


//    return Product that price is greater than given price method
    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product>findByPriceLessThan(BigDecimal price);

//    Containing value query method
    List<Product> findByNameContaining(String name);

//    Find by Like
    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

}
