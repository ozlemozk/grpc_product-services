package com.prodocut.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount_products")
public class DiscountProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "new_price")
    private BigDecimal newPrice;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @OneToMany(mappedBy = "discountProduct", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products;
}
