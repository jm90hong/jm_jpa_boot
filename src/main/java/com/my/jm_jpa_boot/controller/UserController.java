package com.my.jm_jpa_boot.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.jm_jpa_boot.entity.User;
import com.my.jm_jpa_boot.service.UserService;

@RestController
@RequestMapping(value="api/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
//	private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
	
	
	@PostMapping("createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
	
	
	@GetMapping("save")
	public ResponseEntity<User> save(
				@RequestParam(value="id") String id,
				@RequestParam(value="pw") String pw,
				@RequestParam(value="nick") String nick
			) {
		
		User user = User.builder()
			.id(id)
			.pw(passwordEncoder.encode(pw))
			.nick(nick)
			.createdDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
			.build();
                
	    User savedUser = userService.saveUser(user);
		
		return ResponseEntity.ok(savedUser);
	}
	
}
