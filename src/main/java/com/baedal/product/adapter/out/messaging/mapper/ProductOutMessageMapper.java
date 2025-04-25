package com.baedal.product.adapter.out.messaging.mapper;

import com.baedal.product.adapter.out.messaging.dto.SendOrderValidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductOutMessageMapper {

  SendOrderValidate orderValidate(boolean status, String message);

}
