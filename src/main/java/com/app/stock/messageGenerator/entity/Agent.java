package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@ToString
@Table("agent")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Agent {
    @Id
    @Column("uuid")
    private String UUID;

    @Column("agent_id")
    private Gadget agentId;

    @Column("manufacturer")
    private Manufacturer manufacturer;

    @Column("os")
    private OS os;

    @Column("message_uuid")
    private TelemetryMessage telemetryMessage;
}
