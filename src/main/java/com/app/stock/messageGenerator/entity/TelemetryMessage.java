package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "telemetry_message")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TelemetryMessage {
    @Id
    @Column("uuid")
    private String UUID;

    @Column("agent_id")
    private Gadget agentId;

    @Column("previous_message_time")
    private Long previousMessageTime;

    @Column("active_service")
    private ActiveService activeService;

    @Column("quality_score")
    private Integer qualityScore;

    private List<Agent> agents;
}