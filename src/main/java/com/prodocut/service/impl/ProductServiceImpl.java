package com.prodocut.service.impl;

import com.prodocut.aop.exception.MyException;
import com.prodocut.cache.CacheNames;
import com.prodocut.mapper.DiscountProductMapper;
import com.prodocut.mapper.ProductServiceMapper;
import com.prodocut.model.dto.DiscountProductDto;
import com.prodocut.model.dto.ProductDto;
import com.prodocut.model.entity.DiscountProduct;
import com.prodocut.model.entity.Product;
import com.prodocut.repository.DiscountProductRepository;
import com.prodocut.repository.ProductRepository;
import com.prodocut.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

@Service
@Transactional()
@EnableCaching()
public class ProductServiceImpl implements ProductService {
    private final ProductServiceMapper mapper;
    private final ProductRepository repository;
    DiscountProductMapper discountProductMapper;
    DiscountProductRepository discountProductRepository;

    public ProductServiceImpl(ProductServiceMapper mapper,
                              ProductRepository repository,
                              DiscountProductMapper discountProductMapper,
                              DiscountProductRepository discountProductRepository
    ) {
        this.mapper = mapper;
        this.repository = repository;
        this.discountProductMapper = discountProductMapper;
        this.discountProductRepository = discountProductRepository;
    }


    @Override
    @Transactional
    public ProductDto saveProduct(ProductDto dto) {
        DiscountProductDto discountProductDto = dto.getDiscountProduct();
        DiscountProduct discountProductEntity = discountProductMapper.dtoToEntity(discountProductDto);
        DiscountProduct savedDiscountProduct = discountProductRepository.save(discountProductEntity);
        Product entity = mapper.dtoToEntity(dto);
        entity.setDiscountProduct(savedDiscountProduct);
        repository.save(entity);
        return dto;
    }


    @Override
    @Cacheable(CacheNames.PRODUCT_NAMES)
    public ProductDto queryProduct(String name) {

        Product dto = repository.findByName(name);
        if (dto == null) {
            throw new MyException("Product not found: " + name);
        }
        System.out.println("Veritabanına Erişildi! Cache Mekanizması Kullanılmadı.");
        return mapper.entityToDto(dto);
    }


}
