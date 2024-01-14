package com.prodocut.model.dto;

import com.prodocut.model.entity.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "Name cannot be null")
    private String name;

    @DecimalMin(value = "1", inclusive = true, message = "Value must be greater than or equal to 1")
    @Positive(message = "Price must be positive")
    private BigDecimal newPrice;

    @DecimalMin(value = "1", inclusive = true, message = "Value must be greater than or equal to 1")
    @Positive(message = "Price must be positive")
    private BigDecimal oldPrice;


}
