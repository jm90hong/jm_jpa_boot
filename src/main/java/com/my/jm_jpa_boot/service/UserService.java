package com.my.jm_jpa_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.jm_jpa_boot.entity.User;
import com.my.jm_jpa_boot.repository.UserRepository;

@Service
public class UserService {

//	private final UserRepository userRepository;
//
//	public UserService(UserRepository userRepository) {
//	    this.userRepository = userRepository;
//	}
	
	
	
	@Autowired
	UserRepository userRepository;
	

	// Create or Update User
    public User saveUser(User user) {
        return userRepository.save(user);
    }
	
    
    
    
    
    
	
	
	
	
}
