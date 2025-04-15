package com.baedal.product.application.port.in.command;

import com.baedal.product.domain.model.Product;

public interface ProductUseCase {
    ProductCommand.Response createProduct(ProductCommand.Request productCommand);
    Product getProduct(Long productId);
}
