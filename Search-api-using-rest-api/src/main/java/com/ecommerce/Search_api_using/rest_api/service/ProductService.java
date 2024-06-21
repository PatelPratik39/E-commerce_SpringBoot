package com.ecommerce.Search_api_using.rest_api.service;

import com.ecommerce.Search_api_using.rest_api.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
