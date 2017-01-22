package com.tarun.movieflix.api.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tarun.movieflix.api.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User create(User user) {
    	em.persist(user);
		return user;
	}

	@Override
	public User findUser(String username, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.findByUsernamePassword", User.class);
		query.setParameter("uname", username);
		query.setParameter("upassword", password);
		
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}else{
			return null;
		}
	}

	@Override
	public User findByUserName(String username) {
	TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
		query.setParameter("uname", username);

		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		}else {
			return null;
		}		
	}

	@Override
	public User findByID(String userId) {
		return em.find(User.class, userId);
	}

}
