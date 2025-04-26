package com.baedal.product.application.port.in;

import com.baedal.product.application.command.ValidateOrderInfoCommand;

public interface ProductUseCase {

  void validateOrderInfo(ValidateOrderInfoCommand.Request req);
}
