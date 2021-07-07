package com.synechron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.synechron.*.*")
@EnableJpaRepositories("com.synechron.*.*")
@SpringBootApplication
public class OrderMgmtSystemApplication {
	Logger logger = LoggerFactory.getLogger(OrderMgmtSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderMgmtSystemApplication.class, args);
	}

}
