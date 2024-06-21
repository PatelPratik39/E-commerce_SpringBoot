package com.ecommerce.Search_api_using.rest_api.repository;

import com.ecommerce.Search_api_using.rest_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//JPQL query for search query

//it takes Class name instead of tabled name and alias 'p' below
// JPQL query for a search query
    @Query( "SELECT p FROM Product p WHERE"
            + " p.name LIKE CONCAT('%', :query, '%')"
            + " OR p.description LIKE CONCAT('%', :query, '%')" )
    List < Product > searchProduct ( String query );


    //    Native SQL Query take table name instead of Class name
//    @Query(value = "SELECT * FROM products p WHERE"
//            + " p.name LIKE CONCAT('%,:query, '%')"
//            + "Or p.description LIKE CONCAT('%', :query,'%'", nativeQuery = true)
//    List<Product> searchProductSQL(String query);
}
