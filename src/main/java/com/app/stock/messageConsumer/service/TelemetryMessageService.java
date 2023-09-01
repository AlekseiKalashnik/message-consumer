package com.app.stock.messageConsumer.service;

import com.app.stock.messageConsumer.repository.AgentRepository;
import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.entity.TelemetryMessage;
import com.app.stock.messageConsumer.repository.TelemetryMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelemetryMessageService {

    private final AgentRepository agentRepository;
    private final TelemetryMessageRepository messageRepository;

    public void saveMessage(TelemetryMessage message) {
        agentRepository.saveAll(message.getAgents());
        messageRepository.save(message);
        log.info("message has saved");
    }
}
