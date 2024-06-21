package com.ecommerce.Search_api_using.rest_api.service.impl;

import com.ecommerce.Search_api_using.rest_api.entity.Product;
import com.ecommerce.Search_api_using.rest_api.repository.ProductRepository;
import com.ecommerce.Search_api_using.rest_api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> searchProducts(String query) {

       List<Product> products = productRepository.searchProduct(query);
       return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
