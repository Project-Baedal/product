package com.baedal.product.application.service;

import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.application.port.in.command.ProductUseCase;
import com.baedal.product.application.port.out.ProductRepositoryPort;
import com.baedal.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort repositoryPort;


    @Override
    @Transactional
    public ProductCommand.Response createProduct(ProductCommand.Request req) {
        // Command -> Domain
        Product product = Product.builder()
                .name(req.getName())
                .category(req.getCategory())
                .price(req.getPrice())
                .productPictureUrl(req.getProductPictureUrl())
                .storeId(req.getStoreId())
                .build();

        Product savedProduct = repositoryPort.save(product);

        // Domain -> Response
        return ProductCommand.Response.builder()
                .productId(savedProduct.getProductId())
                .name(savedProduct.getName())
                .category(savedProduct.getCategory())
                .price(savedProduct.getPrice())
                .build();
    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }
    @Override
    public List<ProductCommand.Response> getProductsByStoreId(Long storeId) {
        List<Product> products = repositoryPort.findByStoreId(storeId);
        return products.stream()
                .map(product -> ProductCommand.Response.builder()
                        .productId(product.getProductId())
                        .storeId(product.getStoreId())
                        .name(product.getName())
                        .category(product.getCategory())
                        .price(product.getPrice())
                        .productPictureUrl(product.getProductPictureUrl())
                        .build())
                .toList();
    }

}