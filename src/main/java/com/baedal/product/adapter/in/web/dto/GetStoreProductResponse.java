package com.baedal.product.adapter.in.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetStoreProductResponse {

  private Long id;
  private Long name;
  private int price;

}
