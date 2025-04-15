package com.baedal.product.adapter.out.persistence.mapper;

import com.baedal.product.adapter.in.web.response.ProductRes;
import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import com.baedal.product.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    // Entity -> Domain 변환
    Product entityToDomain(ProductEntity productEntity);

    // Domain -> Entity 변환
    ProductEntity domainToEntity(Product product);
}
