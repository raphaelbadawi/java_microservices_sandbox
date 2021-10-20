package net.campusnumerique.dungeoneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DungeoneurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DungeoneurekaApplication.class, args);
	}

}
