package com.tarun.movieflix.api.repository;

import com.tarun.movieflix.api.entity.Rating;

public interface RatingRepository {

	Rating findByID(String ratingId);

	Rating create(Rating rating);

	Rating update(Rating rating);

	void delete(Rating rating);

	double findAvgRatings(String movieId);

}
