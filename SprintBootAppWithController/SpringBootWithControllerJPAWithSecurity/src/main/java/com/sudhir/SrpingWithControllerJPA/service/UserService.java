package com.sudhir.SrpingWithControllerJPA.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user);
	UserDto getUser(String email);
}
