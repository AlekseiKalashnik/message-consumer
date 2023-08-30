package com.app.stock.messageConsumer.service;

import com.app.stock.messageConsumer.entity.TelemetryMessage;
import com.app.stock.messageConsumer.repository.TelemetryMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TelemetryMessageService {

    private final TelemetryMessageRepository messageRepository;

    public Mono<TelemetryMessage> saveMessage(TelemetryMessage message) {
        return messageRepository.save(message);
    }
}
