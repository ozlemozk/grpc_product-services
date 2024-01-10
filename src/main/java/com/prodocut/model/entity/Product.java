package com.prodocut.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "crate_date")
    private LocalDate crateDate;

    @ManyToOne
    @JoinColumn(name = "discountProduct_id", referencedColumnName = "id")
    @JsonBackReference
    private DiscountProduct discountProduct;


}
