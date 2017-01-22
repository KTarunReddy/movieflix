package com.tarun.movieflix.api.service;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarun.movieflix.api.entity.User;
import com.tarun.movieflix.api.exception.BadRequestException;
import com.tarun.movieflix.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public User create(User user) {
		User existing = userRepository.findByUserName(user.getUsername());
		if (existing != null) {
			throw new BadRequestException("User with this username already exists");
		}
		return userRepository.create(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(String username, String password) {
		User user = userRepository.findUser(username, password);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public User findByID(String userId) {
		User user = userRepository.findByID(userId);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}
  
}
