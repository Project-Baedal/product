package com.baedal.product.adapter.in.message.mapper;

import com.baedal.product.adapter.in.message.dto.ValidateOrderInfoMessageIn;
import com.baedal.product.application.command.ValidateOrderInfoCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMessageMapper {

  // 주문 검증
  ValidateOrderInfoCommand.Request validateOrderInfoToCommand(
      ValidateOrderInfoMessageIn.Request req
  );
}
