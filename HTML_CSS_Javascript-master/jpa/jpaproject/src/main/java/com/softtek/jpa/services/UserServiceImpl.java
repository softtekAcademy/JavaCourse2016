package com.softtek.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> findUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(int id) {
		return userRepository.findOne(id);
	}

}
