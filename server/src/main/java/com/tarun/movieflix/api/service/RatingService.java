package com.tarun.movieflix.api.service;

import com.tarun.movieflix.api.entity.Rating;

public interface RatingService {

	Rating create(String movieId, String userId, double rate);

	Rating update(String ratingId, double rate);

	void delete(String ratingId);

	double findAvgRatings(String movieId);
	
}
