package com.app.stock.messageConsumer.service;

import com.app.stock.messageGenerator.entity.TelemetryMessage;
import com.app.stock.messageConsumer.repository.TelemetryMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelemetryMessageService {

    private final TelemetryMessageRepository messageRepository;

    public Mono<TelemetryMessage> saveMessage(TelemetryMessage message) {
        return messageRepository.save(message).doOnSuccess(u -> log.info("saved in DB: {}", u));
    }
}
