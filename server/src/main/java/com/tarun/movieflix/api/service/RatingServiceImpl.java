package com.tarun.movieflix.api.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarun.movieflix.api.entity.Rating;
import com.tarun.movieflix.api.entity.User;
import com.tarun.movieflix.api.entity.Movie;
import com.tarun.movieflix.api.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private MovieService movieService;
		
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public Rating create(String movieId, String userId, double rate) {
		Movie movie = movieService.findByID(movieId);
		User user = userService.findByID(userId);
		Rating rating = new Rating();
		rating.setMovie(movie);
		rating.setUser(user);
		rating.setRating(rate);
    	return ratingRepository.create(rating);
	}

	
	@Override
	@Transactional
	public Rating update(String ratingId, double rate) {
		Rating rating = ratingRepository.findByID(ratingId);
		if (rating == null) {
		   	throw new EntityNotFoundException("Rating not found");
		}
		rating.setRating(rate);
		return ratingRepository.update(rating);
	}

	@Override
	@Transactional
	public void delete(String ratingId) {
		Rating rating = ratingRepository.findByID(ratingId);
		if (rating == null) {
    		throw new EntityNotFoundException("Rating not found");
		}
		ratingRepository.delete(rating);
	}

	@Override
	public double findAvgRatings(String movieId) {
		return ratingRepository.findAvgRatings(movieId);
	}

}
