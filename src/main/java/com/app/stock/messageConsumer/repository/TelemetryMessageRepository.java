package com.app.stock.messageConsumer.repository;

import com.app.stock.messageGenerator.entity.TelemetryMessage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TelemetryMessageRepository extends ReactiveCrudRepository<TelemetryMessage, String> {
}
