package com.ecommerce.Search_api_using.rest_api.repository;

import com.ecommerce.Search_api_using.rest_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
