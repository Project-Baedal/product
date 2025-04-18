package com.baedal.product.adapter.out;

import com.baedal.product.adapter.out.persistence.repository.ProductRepository;
import com.baedal.product.application.mapper.ProductMapper;
import com.baedal.product.application.port.out.ProductRepositoryPort;
import com.baedal.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductPersistenceAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Optional<Product> findById(Long productId) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long productId) {

    }
}
