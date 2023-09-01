package com.app.stock.messageConsumer.service;

import com.app.stock.messageConsumer.repository.AgentRepository;
import com.app.stock.messageConsumer.repository.TelemetryMessageRepository;
import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.entity.TelemetryMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private String payload;
    private final TelemetryMessageRepository messageRepository;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public Mono<TelemetryMessage> getMessageFromTopic(TelemetryMessage message) {
        payload = message.toString();
        log.info("kafka message consumed='{}'", payload + System.currentTimeMillis());
        return this.messageRepository.save(message).doOnSuccess(u -> log.info("message has saved"));
    }
}
