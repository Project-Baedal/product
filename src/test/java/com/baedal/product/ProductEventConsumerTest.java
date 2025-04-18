package com.baedal.product;

import com.baedal.product.application.port.in.command.ProductCommand;
import com.baedal.product.common.utill.JsonUtil;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"product-save-request"}, brokerProperties = {
        "listeners=PLAINTEXT://localhost:9092", "port=9092"
})
public class ProductEventConsumerTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    void testConsume() throws Exception {
        // given
        ProductCommand.Request request = new ProductCommand.Request("치킨", "한식", 15000, "chicken.jpg", 1L);
        String payload = JsonUtil.toJson(request);

        ProducerRecord<String, String> record = new ProducerRecord<>("product-save-request", payload);
        record.headers().add("correlation-id", "1234".getBytes());
        record.headers().add("reply-to", "product-save-reply".getBytes());

        // when
        kafkaTemplate.send(record);

        // then
        // 응답 확인은 ReplyTopic 컨슘하거나 log 찍는 방식으로 확인 가능
    }
}
