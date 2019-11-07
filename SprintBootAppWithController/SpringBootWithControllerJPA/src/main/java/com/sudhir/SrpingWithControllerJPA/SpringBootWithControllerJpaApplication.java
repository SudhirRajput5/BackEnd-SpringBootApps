package com.sudhir.SrpingWithControllerJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sudhir.SrpingWithControllerJPA.service.UserService;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@SpringBootApplication(scanBasePackages="com.sudhir.SrpingWithControllerJPA.service")
public class SpringBootWithControllerJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(SpringBootWithControllerJpaApplication.class, args);

		UserService userService = applicationContext.getBean("userService", UserService.class);

		UserDto userDto = new UserDto();
		userDto.setEmail("testing@gmail.com");
		userDto.setFirstName("Abhinav");
		userDto.setLastName("kumar");
		userDto.setPassword("HIIIIII");
		userService.createUser(userDto);
	}

}
