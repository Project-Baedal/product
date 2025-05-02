package com.baedal.product.application.port.in;

import com.baedal.product.application.command.GetStoreProductCommand;
import com.baedal.product.application.command.ValidateOrderInfoCommand;
import java.util.List;

public interface ProductUseCase {

  void validateOrderInfo(ValidateOrderInfoCommand.Request req);

  List<GetStoreProductCommand.Response> findProductsByStoreId(Long storeId);

}
