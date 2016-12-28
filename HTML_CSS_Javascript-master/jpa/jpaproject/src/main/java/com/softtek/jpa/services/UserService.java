package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.UserEntity;

public interface UserService {

	List<UserEntity> findUsers();
	
	UserEntity findById(int id);
	
}
