package com.synechron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.synechron.*.*")
@EnableJpaRepositories("com.synechron.*.*")
public class OrderMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMgmtSystemApplication.class, args);
	}

}
