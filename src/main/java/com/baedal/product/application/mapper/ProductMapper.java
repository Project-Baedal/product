package com.baedal.product.application.mapper;


import com.baedal.product.adapter.in.web.request.ProductReq;
import com.baedal.product.adapter.in.web.response.ProductRes;
import com.baedal.product.application.port.in.command.ProductCommand;

import com.baedal.product.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductCommand.Request toCommand(ProductReq request);
    Product toDomain(ProductCommand.Request request);
    ProductCommand.Response toResponse(Product product);
    List<ProductCommand.Response> toResponseList(List<Product> products);
}