package com.app.stock.messageConsumer.service;

import com.app.stock.messageGenerator.entity.TelemetryMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final TelemetryMessageService messageService;

    private String payload;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public Mono<TelemetryMessage> getMessageFromTopic(TelemetryMessage message) {
        payload = message.toString();
        log.info("kafka message consumed='{}'", payload + System.currentTimeMillis());
        return messageService.saveMessage(message);
    }
}
