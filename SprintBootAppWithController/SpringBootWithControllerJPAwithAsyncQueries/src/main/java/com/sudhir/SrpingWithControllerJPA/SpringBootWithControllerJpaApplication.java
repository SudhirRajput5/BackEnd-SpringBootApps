package com.sudhir.SrpingWithControllerJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootWithControllerJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithControllerJpaApplication.class, args);

		}

}
