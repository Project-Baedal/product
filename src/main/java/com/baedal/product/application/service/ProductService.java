package com.baedal.product.application.service;

import com.baedal.product.application.command.ValidateOrderInfoCommand;
import com.baedal.product.application.mapper.ProductApplicationMapper;
import com.baedal.product.application.port.in.ProductUseCase;
import com.baedal.product.application.port.out.MessageSenderPort;
import com.baedal.product.application.port.out.ProductRepositoryPort;
import com.baedal.product.domain.business.ProductValidate;
import com.baedal.product.domain.model.ValidateOrderInfo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductUseCase {

  private final ProductApplicationMapper productMapper;
  private final ProductRepositoryPort productRepository;
  private final MessageSenderPort messageSenderPort;
  private final ProductValidate productValidate;

  @Override
  public void validateOrderInfo(ValidateOrderInfoCommand.Request req) {
    // Request 값에서 ID 값만 추출
    ValidateOrderInfo.Request orderInfoReq = productMapper.validateOrderInfoToDomain(req.getProductInfo());

    try {
      // ID 값으로 상품 데이터 조회 | 데이터가 존재하지 않을시 예외 처리
      List<ValidateOrderInfo.Response> orderInfo = productRepository.findByIds(orderInfoReq);

      // 전달 받은 Request 값과 동일한지 검증 | 실패시 예외 처리
      productValidate.validateOrderInfo(req, orderInfo);

      // 성공시 검증 성공 메세지 전달
      messageSenderPort.sendSuccessOrderValidate(req.getOrderTransactionId());

    } catch (Exception e) {
      // 실패시 검증 실패 메세지 전달
      messageSenderPort.sendFailOrderValidate(req.getOrderTransactionId(), e.getMessage());
    }
  }
}
