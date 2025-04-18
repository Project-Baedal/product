package com.baedal.product.adapter.out;

import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.common.utill.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaveReplyProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendResponse(String topic, String correlationId, ProductCommand.Response response) {
        String json = JsonUtil.toJson(response);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, json);
        record.headers().add("correlation-id", correlationId.getBytes());
        kafkaTemplate.send(record);
    }
}