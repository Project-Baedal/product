package com.baedal.product.adapter.out.persistence.repository;

import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
  
  List<ProductEntity> findAllByIdIn(List<Long> ids);

  List<ProductEntity> findByStoreId(Long storeId);

}
