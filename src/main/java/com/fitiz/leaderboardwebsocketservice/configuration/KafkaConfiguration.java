package com.fitiz.leaderboardwebsocketservice.configuration;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Primary
@EnableConfigurationProperties(KafkaProperties.class)
@EnableTransactionManagement
public class KafkaConfiguration {
}
