package com.prodocut.mapper;

import com.prodocut.model.dto.ProductDto;
import com.prodocut.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

//@Mapper
//@Component // veya @Service
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ProductServiceMapper {

    Product dtoToEntity(ProductDto dto);
    ProductDto entityToDto(Product entity);



    //  @Mapping(source = "",)
}


