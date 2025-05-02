package com.baedal.product.adapter.in.web.controller;

import com.baedal.product.adapter.in.web.dto.GetStoreProductResponse;
import com.baedal.product.adapter.in.web.mapper.ProductWebMapper;
import com.baedal.product.application.command.GetStoreProductCommand;
import com.baedal.product.application.port.in.ProductUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ap/product/v0")
@RequiredArgsConstructor
public class ProductController {

  private final ProductUseCase productUseCase;
  private final ProductWebMapper productMapper;

  @GetMapping("/store/{storeId}")
  public ResponseEntity<List<GetStoreProductResponse>> findProductsByStoreId(
      @PathVariable Long storeId
  ) {
    List<GetStoreProductCommand.Response> command = productUseCase.findProductsByStoreId(storeId);
    return ResponseEntity.ok(productMapper.getStoreProductToDto(command));
  }
}
