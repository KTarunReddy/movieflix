package com.tarun.movieflix.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Rating.findAvgRatings",query = "SELECT r from Rating r INNER JOIN r.movie m WHERE m.movieId = :cid")
})
public class Rating {

	@Id
	private String ratingId;
	private double rating;
	@ManyToOne
	private User user;
	@ManyToOne
	private Movie movie;
	
	public String getRatingId() {
		return ratingId;
	}
		
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Rating() {
		this.ratingId = UUID.randomUUID().toString();
	}	
}
