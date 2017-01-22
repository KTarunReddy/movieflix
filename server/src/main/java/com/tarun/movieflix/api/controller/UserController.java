package com.tarun.movieflix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.movieflix.api.entity.User;
import com.tarun.movieflix.api.service.UserService;
	
@RestController
@RequestMapping(value = "users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET,value={"{username}/{password}"})
	public User findUser(@PathVariable("username") String username, @PathVariable("password") String password) {
    	return userService.findUser(username, password);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user){
    	return userService.create(user);
	}
}
