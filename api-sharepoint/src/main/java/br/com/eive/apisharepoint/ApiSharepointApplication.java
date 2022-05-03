package br.com.eive.apisharepoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ApiSharepointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSharepointApplication.class, args);
	}

}
