package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.demo.entity.User;
import com.spring.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public User findUserById(@PathVariable("id") Long id) {
		return userRepository.findOne(id);
	}
	
	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(-1L);
		user.setUsername("defaultUser");
		return user;
	}
	
}
