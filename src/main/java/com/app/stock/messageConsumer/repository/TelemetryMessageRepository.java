package com.app.stock.messageConsumer.repository;

import com.app.stock.messageConsumer.entity.TelemetryMessage;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TelemetryMessageRepository extends R2dbcRepository<TelemetryMessage, String> {
}
