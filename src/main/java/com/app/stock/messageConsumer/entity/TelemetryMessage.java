package com.app.stock.messageConsumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Builder
@Table(name = "telemetry_message")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryMessage {
    @Id
    @Column("uuid")
    @JsonProperty(value = "uuid")
    private String UUID;

    @Column("agent_id")
    @JsonProperty(value = "agent_id")
    private Gadget agentId;

    @Column("previous_message_time")
    @JsonProperty(value = "previous_message_time")
    private Long previousMessageTime;

    @Column("active_service")
    @JsonProperty(value = "active_service")
    private ActiveService activeService;

    @Column("quality_score")
    @JsonProperty(value = "quality_score")
    private Integer qualityScore;

    @JsonProperty(value = "agents")
    @ToString.Exclude
    private List<Agent> agents;
}
