package com.baedal.product.domain.business;

import com.baedal.product.application.command.ValidateOrderInfoCommand.ProductInfo;
import com.baedal.product.application.command.ValidateOrderInfoCommand.Request;
import com.baedal.product.domain.model.ValidateOrderInfo.Response;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductValidate {

  public void validateOrderInfo(Request req, List<Response> res) {

    Long storeId = req.getStoreId();
    List<ProductInfo> productInfo = req.getProductInfo();

    if (productInfo.size() != res.size()) { throw new RuntimeException("상품 정보가 일치하지 않습니다.");}
    // 순서 정렬
    productInfo.sort(Comparator.comparing(ProductInfo::getProductId));
    res.sort(Comparator.comparing(Response::getProductId));

    for (int i = 0; i < productInfo.size(); i++) {
      ProductInfo p = productInfo.get(i);
      Response r = res.get(i);

      // 값이 일치하지 않을 때
      if (
          ! storeId.equals(r.getStoreId())  &&
          ! p.getProductName().equals(r.getProductName()) &&
          p.getPrice() != r.getPrice()
      ) {
        throw new RuntimeException("상품 정보가 일치하지 않습니다.");
      }
    }

  }

}
