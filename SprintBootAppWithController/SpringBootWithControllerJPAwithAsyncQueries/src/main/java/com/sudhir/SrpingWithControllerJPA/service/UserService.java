package com.sudhir.SrpingWithControllerJPA.service;


import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;
import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;
import com.sudhir.SrpingWithControllerJPA.model.response.UserRest;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@Service
public interface UserService {

	UserDto createUser(UserDto user);

	//UserRest findUserbyEmail(String email);

	Iterable<UserEntity> findAllUsesrs();

	void deleteByEmail(String email);

	UserRest updateFirstName(String email, String name);

	CompletableFuture<UserEntity> findByLastName1(String lastName);
}
