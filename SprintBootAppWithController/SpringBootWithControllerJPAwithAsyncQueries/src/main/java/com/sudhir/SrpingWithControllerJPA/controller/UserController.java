package com.sudhir.SrpingWithControllerJPA.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;
import com.sudhir.SrpingWithControllerJPA.model.request.UsersDetailModel;
import com.sudhir.SrpingWithControllerJPA.model.response.UserRest;
import com.sudhir.SrpingWithControllerJPA.service.UserService;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/createUser")
	public UserRest createUser(@RequestBody UsersDetailModel userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		
		BeanUtils.copyProperties(createUser, returnValue);
				
		return returnValue;
	}
	
	/*
	 * @GetMapping(value="/{emailId}") public UserRest
	 * findUserbyEmailId(@PathVariable("emailId") String email) { return
	 * userService.findUserbyEmail(email); }
	 */
	@GetMapping(value="/all")
	public List<UserEntity> searchAll() {
		return (List<UserEntity>) userService.findAllUsesrs();
	}
	
	@PutMapping(value="/updateName/{emailId}/{Name}")
	public UserRest updateFirstName(@PathVariable("emailId") String email, @PathVariable("Name") String Name) {
		return userService.updateFirstName(email, Name);
	}

	@DeleteMapping(value="/{emailId}")
	public void deleteUser(@PathVariable("emailId") String email) {
		userService.deleteByEmail(email);
	}

	@GetMapping(value="/ls/{lastName}")
	public UserEntity findByLastName1(@PathVariable("lastName") String lastName) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<UserEntity> completableFuture = userService.findByLastName1(lastName);
		UserEntity Userentity = completableFuture.get(20,TimeUnit.SECONDS);
		return Userentity;
		
		
	}
}
