package com.baedal.product.adapter.in.web.controller;

import com.baedal.product.adapter.in.web.request.ProductReq;
import com.baedal.product.adapter.in.web.response.ProductRes;

import com.baedal.product.application.mapper.ProductMapper;
import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.application.port.in.command.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper mapper;
    private final ProductUseCase productUseCase;

    @PostMapping("/create")
    public ProductRes createProduct(@RequestBody ProductReq request) {
        ProductCommand.Request command = mapper.toCommand(request);
        ProductCommand.Response response = productUseCase.createProduct(command);

        return mapper.toResponse(response);
    }
}