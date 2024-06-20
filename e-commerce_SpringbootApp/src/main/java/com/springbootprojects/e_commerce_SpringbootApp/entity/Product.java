package com.springbootprojects.e_commerce_SpringbootApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products",
        schema = "eCommerce",
        uniqueConstraints = {
            @UniqueConstraint(name = "sku_unique",
                    columnNames = "sku")
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "stock_keeping_unit", nullable = false)
    private String sku;       //SKU => stock keeping unit
    @Column(nullable = false)
    private String productName;


    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
