package com.prodocut.repository;

import com.prodocut.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    Product findByName(String name);
}
