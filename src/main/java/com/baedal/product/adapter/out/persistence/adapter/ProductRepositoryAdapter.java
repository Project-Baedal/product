package com.baedal.product.adapter.out.persistence.adapter;

import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import com.baedal.product.adapter.out.persistence.manager.ProductReader;
import com.baedal.product.adapter.out.persistence.mapper.ProductPersistenceMapper;
import com.baedal.product.application.port.out.ProductRepositoryPort;
import com.baedal.product.domain.model.ProductInfo;
import com.baedal.product.domain.model.ValidateOrderInfo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

  private final ProductReader productReader;
  private final ProductPersistenceMapper productMapper;

  @Override
  public List<ValidateOrderInfo.Response> findByIds(ValidateOrderInfo.Request req) {
    List<Long> ids = req.getProductIds();
    List<ProductEntity> productEntity = productReader.findByIds(ids);
    return productMapper.findByIdsToDomain(productEntity);
  }

  @Override
  public List<ProductInfo.Response> findByStoreId(Long storeId) {
    List<ProductEntity> productEntity = productReader.findByStoreId(storeId);
    return productMapper.getStoreProductToCommand(productEntity);
  }


}
