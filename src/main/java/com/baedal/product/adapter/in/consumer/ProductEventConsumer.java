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

    private final ProductUseCase productUseCase;         // ✅ 서비스 말고 유즈케이스에 의존!
    private final ProductSaveReplyProducer replyProducer;

    @KafkaListener(topics = "product-save-request", groupId = "product-group")
    public void consume(ConsumerRecord<String, String> record) {
        String payload = record.value();
        String correlationId = new String(record.headers().lastHeader("correlation-id").value());
        String replyTo = new String(record.headers().lastHeader("reply-to").value());

        ProductCommand.Request request = JsonUtil.fromJson(payload, ProductCommand.Request.class);
        ProductCommand.Response response = productUseCase.save(request);   // ✅ 인터페이스 기반 호출

        replyProducer.sendResponse(replyTo, correlationId, response);
    }
}