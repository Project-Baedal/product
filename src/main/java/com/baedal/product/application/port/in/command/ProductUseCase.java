package com.baedal.product.application.port.in.command;

import com.baedal.product.domain.model.Product;

import java.util.List;

public interface ProductUseCase {
    ProductCommand.Response createProduct(ProductCommand.Request productCommand);
    Product getProduct(Long productId);
    List<ProductCommand.Response> getProductsByStoreId(Long storeId);
    ProductCommand.Response save(ProductCommand.Request request);
}
