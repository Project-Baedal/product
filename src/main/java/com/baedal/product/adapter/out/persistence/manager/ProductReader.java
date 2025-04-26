package com.baedal.product.adapter.out.persistence.manager;

import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import com.baedal.product.adapter.out.persistence.repository.ProductJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductReader {

  private final ProductJpaRepository productJpaRepository;

  public List<ProductEntity> findByIds(List<Long> ids) {
    return productJpaRepository.findAllById(ids);
  }

}
