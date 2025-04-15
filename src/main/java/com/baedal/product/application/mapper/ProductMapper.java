package com.baedal.product.application.mapper;


import com.baedal.product.adapter.in.web.request.ProductReq;
import com.baedal.product.adapter.in.web.response.ProductRes;
import com.baedal.product.application.port.in.command.ProductCommand;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductCommand.Request toCommand(ProductReq request);

    ProductRes toResponse(ProductCommand.Response response);
}