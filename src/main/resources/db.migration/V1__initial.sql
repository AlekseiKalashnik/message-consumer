CREATE TABLE telemetry_message
(
    uuid                  varchar PRIMARY KEY,
    agent_id              varchar,
    previous_message_time bigint,
    active_service        varchar,
    quality_score         int
);

CREATE TABLE agent
(
    uuid         varchar PRIMARY KEY,
    agent_id     varchar,
    manufacturer varchar,
    os           varchar,
    FOREIGN KEY (agent_id) REFERENCES telemetry_message (agent_id)
);