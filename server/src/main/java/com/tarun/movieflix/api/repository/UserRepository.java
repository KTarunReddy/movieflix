package com.tarun.movieflix.api.repository;

import com.tarun.movieflix.api.entity.User;

public interface UserRepository {
   
	public User create(User user);
	
	public User findUser(String username, String password);

	public User findByUserName(String username);

	public User findByID(String userId);
}
