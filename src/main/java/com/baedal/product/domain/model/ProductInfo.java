package com.baedal.product.domain.model;

import lombok.Builder;
import lombok.Getter;

public class ProductInfo {


  @Getter
  @Builder
  public static class Response {
    private Long id;
    private String name;
    private int price;
  }

}
