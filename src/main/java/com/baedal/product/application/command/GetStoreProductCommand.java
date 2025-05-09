package com.baedal.product.application.command;

import lombok.Builder;
import lombok.Getter;

public class GetStoreProductCommand {


  @Getter
  @Builder
  public static class Response {
    private Long id;
    private Long name;
    private int price;
  }

}
