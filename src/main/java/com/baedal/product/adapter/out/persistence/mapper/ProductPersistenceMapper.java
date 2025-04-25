package com.baedal.product.adapter.out.persistence.mapper;

import com.baedal.product.adapter.out.persistence.entity.ProductEntity;
import com.baedal.product.domain.model.ValidateOrderInfo;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    List<ValidateOrderInfo.Response> findByIdsToDomain(List<ProductEntity> entity);

    @Mapping(target = "productId", source = "id")
    @Mapping(target = "productName", source = "name")
    ValidateOrderInfo.Response validateOrderInfoToDomain(ProductEntity entity);
}
