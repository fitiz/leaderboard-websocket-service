package com.fitiz.leaderboardwebsocketservice.repository;

import com.fitiz.leaderboardwebsocketservice.provider.LeaderboardRedisProvider;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardRedisRepository {

    private final LeaderboardRedisProvider leaderboardRedisProvider;

    public LeaderboardRedisRepository(LeaderboardRedisProvider leaderboardRedisProvider) {
        this.leaderboardRedisProvider = leaderboardRedisProvider;
    }
}
