package com.team.teamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.team.teamapi.player", "com.team.teamapi.team"})
public class TeamapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamapiApplication.class, args);
	}

}
