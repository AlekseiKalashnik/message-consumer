CREATE TABLE if not exists agent
(
    uuid         varchar PRIMARY KEY,
    agent_id     varchar,
    manufacturer varchar,
    os           varchar
);

CREATE TABLE if not exists telemetry_message
(
    uuid                  varchar PRIMARY KEY,
    agent_id              varchar,
    previous_message_time bigint,
    active_service        varchar,
    quality_score         int,
    agent_uuid varchar REFERENCES agent (uuid)
);


insert into agent values ('ppooop', 'PC', 'SONY', 'IOS');

-- insert into agent values ('rrr', 'PC', 'SONY', 'IOS');
-- insert into telemetry_message values ('mmm',
--     'Laptop', 1693193946, 'IVI', 21,'rrr');

-- drop table telemetry_message;
-- drop table agent;

-- select active_service, manufacturer from telemetry_message left join agent on telemetry_message.agent_uuid = agent.uuid;