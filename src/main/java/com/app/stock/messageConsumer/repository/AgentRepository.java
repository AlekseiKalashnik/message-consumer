package com.app.stock.messageConsumer.repository;

import com.app.stock.messageGenerator.entity.Agent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AgentRepository extends ReactiveCrudRepository<Agent, String> {
}
