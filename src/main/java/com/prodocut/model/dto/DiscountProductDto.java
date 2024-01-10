package com.prodocut.model.dto;

import com.prodocut.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountProductDto {
    private List<Product> products;

    private Long id;
    private String name;
    private BigDecimal newPrice;
    private BigDecimal oldPrice;


}
