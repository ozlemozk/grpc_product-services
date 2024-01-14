package com.prodocut.model.dto;

import com.prodocut.model.entity.DiscountProduct;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    //TODO:dil desteği vs ekle
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @DecimalMin(value = "1", inclusive = true, message = "Value must be greater than or equal to 1")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price must be positive or zero")
    private int stock;

/*
    @PastOrPresent(message = "Creation date must be in the past or present")
    @DateTimeFormat()
    private LocalDate crateDate;
*/

    @Valid
    @NotNull(message = "At least one discount product must be present")
    private DiscountProductDto discountProduct;


}
