package com.app.stock.messageConsumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "agent")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
    @Id
    @Column("uuid")
    @JsonProperty(value = "uuid")
    private String UUID;

    @Column("agent_id")
    @JsonProperty(value = "agent_id")
    private Gadget agentId;

    @Column("manufacturer")
    @JsonProperty(value = "manufacturer")
    private Manufacturer manufacturer;

    @Column("os")
    @JsonProperty(value = "os")
    private OS os;
}
