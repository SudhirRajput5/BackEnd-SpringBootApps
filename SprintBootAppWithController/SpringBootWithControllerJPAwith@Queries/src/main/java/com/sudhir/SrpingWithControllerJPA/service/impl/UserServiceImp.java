package com.sudhir.SrpingWithControllerJPA.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sudhir.SrpingWithControllerJPA.UserRepository;
import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;
import com.sudhir.SrpingWithControllerJPA.model.response.UserRest;
import com.sudhir.SrpingWithControllerJPA.service.UserService;
import com.sudhir.SrpingWithControllerJPA.shared.Utils;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity storedDetails = userRepository.findByEmail(user.getEmail());
		
		if(storedDetails!=null) {
			throw new RuntimeException("Record already exixts");
		}
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		
		
		userEntity.setEncryptedPassword("aaa");
		userEntity.setUserId(publicUserId);
		
		UserEntity storedvalue = userRepository.save(userEntity);
		
		UserDto returnvalue = new UserDto();
		BeanUtils.copyProperties(storedvalue, returnvalue);
		return returnvalue;
	}

	@Override
	public UserRest findUserbyEmail(String email) {
		UserRest returnValue = new UserRest();
		
		UserEntity findUser = userRepository.UserinfoLastname(email);
		
		BeanUtils.copyProperties(findUser, returnValue);
		
		return returnValue;
		
	}

	@Override
	public Iterable<UserEntity> findAllUsesrs() {
		return userRepository.findAll();
	}

	@Override
	public void deleteByEmail(String email) {
		
		UserEntity storedDetails = userRepository.findByEmail(email);
		if(storedDetails == null) {
			throw new RuntimeException("Record does not exists");
		}
		else {
			userRepository.delete(storedDetails);
		}
	}

	@Override
	public UserRest updateFirstName(String email, String name) {
		
		UserEntity storedDetail = userRepository.findByEmail(email);
		if(storedDetail==null) {
			throw new RuntimeException("NO records found");
		}
		storedDetail.setFirstName(name);
		UserEntity storedValue = userRepository.save(storedDetail);
		
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(storedDetail, returnValue);
		
		return returnValue;
		
	}

}
