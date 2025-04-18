package com.baedal.product.adapter.out;

import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import com.baedal.product.adapter.out.persistence.mapper.ProductPersistenceMapper;
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
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Optional<Product> findById(Long productId) {
        // TODO: productId로 ProductEntity를 조회하고, entityToDomain 변환 후 Optional로 감싸서 반환
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        // TODO: 모든 ProductEntity를 조회하고, entityToDomain으로 변환 후 리스트 반환
        return List.of();
    }

    @Override
    public Product save(Product product) {
        // TODO: Domain 객체를 entity로 변환한 뒤, 저장하고 다시 domain으로 변환하여 반환
        return null;
    }

    @Override
    public void deleteById(Long productId) {
        // TODO: productId로 ProductEntity를 삭제
    }

    @Override
    public List<Product> findByStoreId(Long storeId) {
        return productRepository.findByStoreId(storeId).stream()
                .map(productPersistenceMapper::entityToDomain)
                .toList();
    }
}
