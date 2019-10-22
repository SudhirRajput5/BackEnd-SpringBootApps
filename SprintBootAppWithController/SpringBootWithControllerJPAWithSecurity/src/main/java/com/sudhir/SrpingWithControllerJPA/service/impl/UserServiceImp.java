package com.sudhir.SrpingWithControllerJPA.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sudhir.SrpingWithControllerJPA.UserRepository;
import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;
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
		
		
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(publicUserId);
		
		UserEntity storedvalue = userRepository.save(userEntity);
		
		UserDto returnvalue = new UserDto();
		BeanUtils.copyProperties(storedvalue, returnvalue);
		return returnvalue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
