package com.prodocut.model.dto;

import com.prodocut.model.entity.DiscountProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    //TODO: nutNull GİBİ İFADELER EKLENMLİ 0DA BÜYÜK VS
    private Long id;
    private String name;
    private BigDecimal price;
    private int stock;
    private LocalDate crateDate;

    private DiscountProductDto discountProduct;


}
