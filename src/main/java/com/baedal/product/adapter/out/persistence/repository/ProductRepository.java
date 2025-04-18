package com.baedal.product.adapter.out.persistence.repository;

import com.baedal.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Product 엔티티가 있다고 가정
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 필요한 경우 커스텀 메서드 추가 가능
    Product findByName(String name);
}
