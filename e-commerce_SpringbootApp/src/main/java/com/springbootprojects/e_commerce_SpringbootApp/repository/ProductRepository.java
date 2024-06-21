package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

//    find price between 2 price range
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

//    find Date between 2 dates
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

//    In Predicate Query Method
    List<Product> findByNameIn(List<String> names);

//    Limit the query
    List<Product> findFirst6ByOrderByNameAsc();

    List<Product> findTop3ByOrderByPriceDesc();

    /*

    Define JPQL Query using @Query annotation

     */

    @Query("SELECT p from Product p where p.name = ?1 or p.description = ?2")
    Product findByNameOrDescriptionJPQLIndexParam(String name, String description);


//    Define JPQL Query using @Query annotation with Named Parameters

    @Query("SELECT p FROM Product p where p.name = :name or p.description = :description")
    Product findByNameOrDescriptionJPQLNamedParam(@Param("name") String name,
                                                  @Param("description") String description);

//    Define NATIVE SQL query using @Query annotation with index or position parameters

    @Query(value = "select * from products p where p.name =?1 or p.description= ?2", nativeQuery = true)
   Product findByNameOrDescriptionSQLIndexParam(String name, String description);

//    Define Native SQL Query using @Query annotation with Named Parameters
    @Query(value = "select * from products p where p.name = :name or p.description = :description",
            nativeQuery = true)
    Product findByNameOrDescriptionSQLNamedParam(String name, String description);

}
