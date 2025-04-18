package com.baedal.product.adapter.in.consumer;

import com.baedal.product.adapter.out.ProductSaveReplyProducer;
import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.application.port.in.command.ProductUseCase;
import com.baedal.product.application.service.ProductService;
import com.baedal.product.common.utill.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductEventConsumer {

    private final ProductUseCase productUseCase;
    private final ProductSaveReplyProducer replyProducer;

    @KafkaListener(topics = "product-save-request", groupId = "product-group")
    public void consume(ConsumerRecord<String, String> record) {
        String payload = record.value();
        log.info("Kafka 메시지 수신됨: {}", payload);
        String correlationId = new String(record.headers().lastHeader("correlation-id").value());
        String replyTo = new String(record.headers().lastHeader("reply-to").value());

        ProductCommand.Request request = JsonUtil.fromJson(payload, ProductCommand.Request.class);
        ProductCommand.Response response = productUseCase.save(request);

        replyProducer.sendResponse(replyTo, correlationId, response);
    }
}