package com.baedal.product.adapter.in.message.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

public class ValidateOrderInfoMessageIn {

  @Getter
  @Builder
  public static class Request {
    @Schema(description = "주문 고유 ID")
    private String orderTransactionId;

    @Schema(description = "매장 ID")
    private Long storeId;

    @Schema(description = "배달비")
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
