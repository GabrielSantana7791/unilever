package com.unilever.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unilever.request.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUserNameAndPassword(String userName, String password);

}
