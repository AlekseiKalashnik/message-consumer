package com.app.stock.messageConsumer.service;

import com.app.stock.messageGenerator.entity.TelemetryMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final TelemetryMessageService messageService;

    private String payload;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void getMessageFromTopic(TelemetryMessage message) {
        log.info("kafka message consumed='{}'", message.toString() + System.currentTimeMillis());
        messageService.saveMessage(message);
        payload = message.toString();
    }
}
