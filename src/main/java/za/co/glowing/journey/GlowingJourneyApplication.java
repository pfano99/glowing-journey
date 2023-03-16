package za.co.glowing.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GlowingJourneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlowingJourneyApplication.class, args);
	}

}
