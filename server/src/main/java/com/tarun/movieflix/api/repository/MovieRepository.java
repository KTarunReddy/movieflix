package com.tarun.movieflix.api.repository;

import java.util.List;

import com.tarun.movieflix.api.entity.Movie;

public interface MovieRepository {

	public Movie create(Movie media);
	
	public Movie update(Movie movie);

	public void delete(Movie existing);

	public List<Movie> findAll();

	public List<Movie> findTopRatedMovies(String type);

	public List<Movie> findByFilter(String type, int year, String genre, String sort);

	public Movie findByTitle(String title);
	
	public List<Movie> findByTitleSubstring(String title);

	public String getImdbID(String title);

	public Movie findByID(String movieId);
}
