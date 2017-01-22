package com.tarun.movieflix.api.service;

import com.tarun.movieflix.api.entity.User;

public interface UserService {

	public User create(User user);
	
	public User findUser(String username, String password);
	
	public User findByID(String userId);

}

