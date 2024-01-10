package com.prodocut.service.impl;

import com.prodocut.mapper.ProductServiceMapper;
import com.prodocut.model.dto.ProductDto;
import com.prodocut.repository.ProductRepository;
import com.prodocut.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductServiceMapper mapper;
    private final ProductRepository repository;

    public ProductServiceImpl(ProductServiceMapper mapper, ProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public ProductDto saveProduct(ProductDto dto) {
        return null;
    }
}
