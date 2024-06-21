package com.springbootprojects.e_commerce_SpringbootApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="product_generator" )
    @SequenceGenerator(name = "product_generator",
    sequenceName = "product_sequence_name",
    allocationSize = 1)
    private Long id;
    @Column(name= "stock_keeping_unit", nullable = false)
    private String sku;       //SKU => stock keeping unit
    @Column(nullable = false)
    private String name;


    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
