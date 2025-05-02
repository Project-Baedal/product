package com.baedal.product.application.port.out;

import com.baedal.product.domain.model.ProductInfo;
import com.baedal.product.domain.model.ValidateOrderInfo;
import java.util.List;

public interface ProductRepositoryPort {

  List<ValidateOrderInfo.Response> findByIds(ValidateOrderInfo.Request req);

  List<ProductInfo.Response> findByStoreId(Long storeId);
}
