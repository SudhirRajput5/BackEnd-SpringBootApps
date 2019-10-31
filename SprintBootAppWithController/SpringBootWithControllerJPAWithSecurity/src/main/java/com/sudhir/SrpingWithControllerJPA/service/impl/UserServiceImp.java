package com.sudhir.SrpingWithControllerJPA.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;
import com.sudhir.SrpingWithControllerJPA.io.repository.UserRepository;
import com.sudhir.SrpingWithControllerJPA.service.UserService;
import com.sudhir.SrpingWithControllerJPA.shared.Utils;
import com.sudhir.SrpingWithControllerJPA.shared.dto.UserDto;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity storedDetails = userRepository.findByEmail(user.getEmail());
		
		if(storedDetails!=null) {
			throw new RuntimeException("Record already exixts");
		}
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId = utils.generateUserId(30);
		
		
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));		//Password hashing function is use to encode the password.
		userEntity.setUserId(publicUserId);
		
		UserEntity storedvalue = userRepository.save(userEntity);
		
		UserDto returnvalue = new UserDto();
		BeanUtils.copyProperties(storedvalue, returnvalue);
		return returnvalue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {   //load user details form DB
		UserEntity userEntity = userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList());
	}

	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}

}
