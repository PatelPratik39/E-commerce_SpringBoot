package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository<Product, Long> {


}
