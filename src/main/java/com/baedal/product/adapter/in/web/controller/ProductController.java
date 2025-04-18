package com.baedal.product.adapter.in.web.controller;

import com.baedal.product.adapter.in.web.request.ProductReq;
import com.baedal.product.adapter.in.web.response.ProductRes;

import com.baedal.product.application.mapper.ProductMapper;
import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.application.port.in.command.ProductUseCase;
import com.baedal.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductUseCase productUseCase;

    @PostMapping("/create")
    public ResponseEntity<ProductCommand.Response> createProduct(@RequestBody ProductReq request) {
        ProductCommand.Request command = productMapper.toCommand(request); // 🔁
        ProductCommand.Response response = productUseCase.createProduct(command); // 🔁
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductCommand.Response>> getProductsByStoreId(@RequestParam Long storeId) {
        List<ProductCommand.Response> responses = productUseCase.getProductsByStoreId(storeId);
        return ResponseEntity.ok(responses);
    }
}