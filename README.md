### Challenge service Kafka consumer for leaderboard

- Kafka consumer for providing leaderboard cache via WebSocket

```java
@KafkaListener(
        topics = {"${prop.config.broker-properties.leaderboard-topic}"},
        groupId = "${prop.config.broker-properties.leaderboard-topic-consumer-group-id}",
        properties = {"spring.json.value.default.type=com.fitiz.leaderboardwebsocketservice.model.LeaderboardCache"})
public void leaderboardConsumer(ConsumerRecord<String, LeaderboardCache> record){
    var leaderboard = record.value();
    log.info("Leaderboard {} consumed with timestamp {}",leaderboard.leaderboardKey(), leaderboard.lastUpdatedTimeMs());
    simpMessagingTemplate.convertAndSend("/leaderboard/" + leaderboard.leaderboardKey(), leaderboard);
}
```

- Consumes Leaderboard topic and pushes it to WebSocket at ```/leaderboard/" + leaderboard.leaderboardKey()```

_Please see the [WebSocketConfig.java](https://github.com/fitiz/leaderboard-websocket-service/blob/main/src/main/java/com/fitiz/leaderboardwebsocketservice/configuration/WebSocketConfig.java) for STOMP protocol._
