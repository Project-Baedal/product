package com.baedal.product.domain.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateOrderInfo {

  @Getter
  @Builder
  public static class Request {
    private List<Long> productIds;
  }

  @Getter
  @Builder
  public static class Response {

    private Long storeId;
    private Long productId;
    private String productName;
    private int price;

  }


}
