package com.prodocut.service;

import com.prodocut.model.dto.ProductDto;
import com.prodocut.model.entity.Product;

public interface ProductService {
    ProductDto saveProduct(ProductDto dto);

    ProductDto queryProduct(String name);
}
