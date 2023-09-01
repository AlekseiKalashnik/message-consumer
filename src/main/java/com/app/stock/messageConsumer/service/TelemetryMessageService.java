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

    public Mono<TelemetryMessage> saveMessage(TelemetryMessage message) {
        List<Agent> agentList = message.getAgents();
        agentRepository.saveAll(agentList);
        log.info("agents have saved");
        return messageRepository.save(message.toBuilder()
                .UUID(message.getUUID())
                .agentId(message.getAgentId())
                .previousMessageTime(message.getPreviousMessageTime())
                .activeService(message.getActiveService())
                .qualityScore(message.getQualityScore())
                .agents(agentList)
                .build()
        ).doOnSuccess(u -> log.info("message has saved"));
    }
}
