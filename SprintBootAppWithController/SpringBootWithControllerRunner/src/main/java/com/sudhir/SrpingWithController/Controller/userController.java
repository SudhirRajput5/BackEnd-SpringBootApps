package com.sudhir.SrpingWithController.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class userController {

	@GetMapping
	@RequestMapping("/getusser")
	public String getUser(){
		return "getuserrestcall";
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
