package com.fitiz.leaderboardwebsocketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fitiz.leaderboardwebsocketservice"})
public class LeaderboardWebsocketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderboardWebsocketServiceApplication.class, args);
	}

}
