package com.fitiz.leaderboardwebsocketservice.service;

import com.fitiz.leaderboardwebsocketservice.model.LeaderboardCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LeaderboardConsumer {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(
            topics = {"${prop.config.broker-properties.leaderboard-topic}"},
            groupId = "${prop.config.broker-properties.leaderboard-topic-consumer-group-id}",
            properties = {"spring.json.value.default.type=com.fitiz.leaderboardwebsocketservice.model.LeaderboardCache"})
    public void leaderboardConsumer(ConsumerRecord<String, LeaderboardCache> record){
        var leaderboard = record.value();
        log.info("Leaderboard {} consumed with timestamp {}",leaderboard.leaderboardKey(), leaderboard.lastUpdatedTimeMs());
        simpMessagingTemplate.convertAndSend("/leaderboard/" + leaderboard.leaderboardKey(), leaderboard);
    }
}