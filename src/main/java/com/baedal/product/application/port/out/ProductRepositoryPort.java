package com.baedal.product.application.port.out;

import com.baedal.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Optional<Product> findById(Long productId);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long productId);
}