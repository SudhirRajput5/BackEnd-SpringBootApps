package com.sudhir.SrpingWithControllerJPA.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.SrpingWithControllerJPA.model.request.UsersDetailModel;
import com.sudhir.SrpingWithControllerJPA.model.response.UserRest;
import com.sudhir.SrpingWithControllerJPA.service.UserService;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public UserRest createUser(@RequestBody UsersDetailModel userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		
		BeanUtils.copyProperties(createUser, returnValue);
				
		return returnValue;
	}
	
	@GetMapping
	public String getUser() {
		return "hiiiiiiiiiiii";
	}

}
