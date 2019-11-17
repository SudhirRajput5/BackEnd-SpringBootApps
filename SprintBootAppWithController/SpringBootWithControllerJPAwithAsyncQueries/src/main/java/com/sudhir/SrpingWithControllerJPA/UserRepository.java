package com.sudhir.SrpingWithControllerJPA;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.sudhir.SrpingWithControllerJPA.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);

	@Async
	CompletableFuture<UserEntity> findBylastName(String lastName);

}
