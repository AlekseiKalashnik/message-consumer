package com.app.stock.messageConsumer.repository;

import com.app.stock.messageGenerator.entity.Agent;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AgentRepository extends R2dbcRepository<Agent, String> {
}
