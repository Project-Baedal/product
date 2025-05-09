package com.baedal.product.adapter.in.web.mapper;

import com.baedal.product.adapter.in.web.dto.GetStoreProductResponse;
import com.baedal.product.application.command.GetStoreProductCommand;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductWebMapper {

  // 매장 상품 조회
  List<GetStoreProductResponse> getStoreProductToDto(List<GetStoreProductCommand.Response> res);
}
