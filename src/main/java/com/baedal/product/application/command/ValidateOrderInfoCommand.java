package com.baedal.product.application.command;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateOrderInfoCommand {

  @Getter
  @Builder
  public static class Request {

    private String orderTransactionId;
    private Long storeId;
    private List<ProductInfo> productInfo;
  }


  @Getter
  @Builder
  public static class ProductInfo {
    private Long productId;
    private String productName;
    private int price;
  }

}
