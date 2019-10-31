package com.sudhir.SrpingWithController;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWithControllerOnlyApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithControllerOnlyApplication.class, args);
	}

	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * 
	 * System.out.println("HIiiiiiiiiiiiiiiiiiiiiiiiii this is Sudhir");
	 * 
	 * }
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("HIiiiiiiiiiiiiiiiiiii this is Rinku");
		
	}

}
