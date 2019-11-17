package com.sudhir.SrpingWithControllerJPA;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);
	
	@Query(value ="select u from UserEntity u where u.lastName=?1 ") 
	UserEntity UserinfoLastname(String email);

}
