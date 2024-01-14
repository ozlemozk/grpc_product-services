package com.prodocut.repository;

import com.prodocut.model.entity.DiscountProduct;
import com.prodocut.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountProductRepository extends JpaRepository<DiscountProduct, Integer> {

}