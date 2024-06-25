package com.springbootprojects.e_commerce_SpringbootApp.repository;

import com.springbootprojects.e_commerce_SpringbootApp.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
       int pageNo = 0;
       int pageSize = 5;

//       Create Pageable Object
        Pageable pageable = PageRequest.of(pageNo,pageSize);

//        findAll method and pass pageable instance
        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

//        Iterate of over Product
        products.forEach((p) -> {
            System.out.println(p);
        });

//        total pages
        int totalPage = page.getTotalPages();

//        total elements
        long totalElements = page.getTotalElements();

//        total of elements
        int numberOfElements = page.getNumberOfElements();

//        size
        int size = page.getSize();

//        last
        boolean isLast = page.isLast();
//        first
        boolean isFirst = page.isFirst();
        System.out.println("total Page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println(" Number Of Elements -> " + numberOfElements);
        System.out.println(" Size -> " + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> "+ isFirst);

    }

    @Test
    void sorting(){
        String sortBy = "price";
        String sortDir = "desc";
//Sorting dynamically based on previous status

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

//        List<Product> products = productRepository.findAll(Sort.by(sortBy).descending());
//        List<Product> products = productRepository.findAll(Sort.by(sortBy));

//        conditional Sorting
        List<Product> products = productRepository.findAll(sort);

        products.forEach((p) -> {
            System.out.println(p);
        });
    }


}
