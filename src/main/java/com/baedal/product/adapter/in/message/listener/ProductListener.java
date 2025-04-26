package com.baedal.product.adapter.in.message.listener;

import com.baedal.product.adapter.in.message.dto.ValidateOrderInfoMessageIn;
import com.baedal.product.adapter.in.message.mapper.ProductMessageMapper;
import com.baedal.product.application.command.ValidateOrderInfoCommand;
import com.baedal.product.application.port.in.ProductUseCase;
import com.baedal.product.util.Converter;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductListener {

  private final Converter converter;
  private final ProductMessageMapper productMapper;
  private final ProductUseCase productUseCase;

  @KafkaListener(topics = "product.validateProductOrderInfo", groupId = "product-group")
  public void validateOrderInfo(ConsumerRecord<String, String> record) {
    ValidateOrderInfoMessageIn.Request req = converter.jsonToDto(
        record.value(), ValidateOrderInfoMessageIn.Request.class
    );

    ValidateOrderInfoCommand.Request command = productMapper.validateOrderInfoToCommand(req);
    productUseCase.validateOrderInfo(command);
  }

}
