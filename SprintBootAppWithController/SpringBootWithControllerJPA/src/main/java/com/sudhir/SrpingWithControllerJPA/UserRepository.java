package com.sudhir.SrpingWithControllerJPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);
	UserEntity findBylastNameUserInfo(String email);

}
