package com.fitiz.leaderboardwebsocketservice.model;

import java.io.Serializable;
import java.util.List;

public record LeaderboardCache(String leaderboardKey, List<LeaderboardUser> participants,
                               long lastUpdatedTimeMs) implements Serializable {
}
