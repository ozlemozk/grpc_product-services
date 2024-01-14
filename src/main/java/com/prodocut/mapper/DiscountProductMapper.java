package com.prodocut.mapper;

import com.prodocut.model.dto.DiscountProductDto;
import com.prodocut.model.dto.ProductDto;
import com.prodocut.model.entity.DiscountProduct;
import com.prodocut.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DiscountProductMapper {
    DiscountProduct dtoToEntity(DiscountProductDto dto);
    DiscountProductDto entityToDto(DiscountProduct entity);
}
