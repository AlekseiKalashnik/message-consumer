package com.app.stock.messageConsumer.service;

import com.app.stock.messageConsumer.repository.AgentRepository;
import com.app.stock.messageConsumer.repository.TelemetryMessageRepository;
import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.entity.TelemetryMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private String payload;
    private final TelemetryMessageRepository messageRepository;
    private final AgentRepository agentRepository;

    @Transactional
    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")

    public void getMessageFromTopic(TelemetryMessage message) {
        payload = message.toString();
        log.info("kafka message consumed in - " + System.currentTimeMillis());
        List<Agent> agents = message.getAgents();
        log.info("{} - agents saved", agents.size());
        agentRepository.saveAll(Flux.fromIterable(agents)).subscribe();

        messageRepository.save(TelemetryMessage.builder()
                        .UUID(message.getUUID())
                        .agentId(message.getAgentId())
                        .previousMessageTime(message.getPreviousMessageTime())
                        .activeService(message.getActiveService())
                        .qualityScore(message.getQualityScore())
                        .build())
                .subscribe();
        log.info("message saved");
    }
}
