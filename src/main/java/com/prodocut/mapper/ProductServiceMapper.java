package com.prodocut.mapper;

import com.prodocut.model.dto.ProductDto;
import com.prodocut.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ProductServiceMapper {

    Product dtoToEntity(ProductDto dto);

    ProductDto entityToDto(Product entity);

}


