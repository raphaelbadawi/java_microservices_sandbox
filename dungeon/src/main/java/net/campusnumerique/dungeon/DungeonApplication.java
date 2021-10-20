package net.campusnumerique.dungeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DungeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DungeonApplication.class, args);
	}

}
