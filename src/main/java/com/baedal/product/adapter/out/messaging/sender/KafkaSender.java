package com.baedal.product.adapter.out.messaging.sender;

import com.baedal.product.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSender {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topic, String key, Object message) {
    String json = ObjectMapperUtil.toJson(message);
    kafkaTemplate.send(topic, key, json);
  }

}
