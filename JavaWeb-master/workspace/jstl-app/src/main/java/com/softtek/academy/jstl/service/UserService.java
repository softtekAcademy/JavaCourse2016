package com.softtek.academy.jstl.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.softtek.academy.jstl.domain.model.User;
import com.softtek.academy.jstl.repository.UserRepository;

public class UserService {
	
    private UserRepository userRepository = new UserRepository();

    
    public List<User> list() {
        return this.userRepository.list();
    }
    
    public User findOne(final String username) {
        return this.userRepository.findOne(username);
    }
    
    public Boolean update(final User user) {
    	if (this.isValidUser(user)) {
    		userRepository.update(user);
    		
    		return true;
    	}
    	
    	return false;
    }
    
    private Boolean isValidUser(final User user) {
    	if (StringUtils.isBlank(user.getPassword())) {
    		return false;
    	}
    	
    	if (StringUtils.isBlank(user.getName())) {
    		return false;
    	}
    	
    	if (user.getUserRole() == null || user.getUserRole().getId().isEmpty()) {
    		return false;
    	}
    	
    	return true;
    }
}
