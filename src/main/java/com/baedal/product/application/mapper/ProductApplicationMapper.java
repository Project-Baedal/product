package com.baedal.product.application.mapper;

import com.baedal.product.application.command.GetStoreProductCommand;
import com.baedal.product.application.command.ValidateOrderInfoCommand;
import com.baedal.product.domain.model.ProductInfo;
import com.baedal.product.domain.model.ValidateOrderInfo;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductApplicationMapper {

  // 주문 검증
  default ValidateOrderInfo.Request validateOrderInfoToDomain(List<ValidateOrderInfoCommand.ProductInfo> req) {
    List<Long> productIds = req.stream()
        .map(ValidateOrderInfoCommand.ProductInfo::getProductId)
        .toList();
    return ValidateOrderInfo.Request.builder()
        .productIds(productIds)
        .build();
  }

  // 매장 상품 조회
  List<GetStoreProductCommand.Response> getStoreProductToDto(
      List<ProductInfo.Response> productInfos
  );

}
