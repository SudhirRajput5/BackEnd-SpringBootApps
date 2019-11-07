package com.sudhir.SrpingWithController.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class userController {

	Logger logger = LoggerFactory.getLogger(userController.class);
	
	@Value("${spring.application.name:SudhirRajputApplication}")
	private String name;
	
	@GetMapping
	@RequestMapping("/getusser")
	public String getUser(){
		logger.error("This is a logging example");
		logger.info("this is logging info");
		logger.warn("this is logging warning");
		logger.debug("this is logging debug");
		
		return name;
		
	}
	
	
	@PostMapping
	public String createUser() {
		return "createUer";
	}
	
	@PutMapping
	public String updateUser() {
		return "updateuser";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "deleteuser";
	}
	
}
