package com.tarun.movieflix.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarun.movieflix.api.entity.Movie;
import com.tarun.movieflix.api.exception.BadRequestException;
import com.tarun.movieflix.api.exception.EntityNotFoundException;
import com.tarun.movieflix.api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = movieRepository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new BadRequestException("Movie with this title already exists");
		}
		return movieRepository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String title, Movie movie) {
		Movie existing = movieRepository.findByTitle(title);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return movieRepository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String title) {
		Movie existing = movieRepository.findByTitle(title);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		movieRepository.delete(existing);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Movie findByTitle(String title) {
		Movie existing = movieRepository.findByTitle(title);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return existing;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByTitleSubstring(String title) {
		return movieRepository.findByTitleSubstring(title);
	}

	@Override
	public List<Movie> findTopRatedMovies(String type) {
       	return movieRepository.findTopRatedMovies(type);
	}

	@Override
	public List<Movie> findByFilter(String type, int year, String genre, String sort) {
		return movieRepository.findByFilter(type, year, genre, sort);
	}

	@Override
	public String getImdbID(String title) {
		Movie existing = movieRepository.findByTitle(title);
		if(existing == null){
			throw new EntityNotFoundException("Movie not found");
		}
		return movieRepository.getImdbID(title);
	}

	@Override
	@Transactional(readOnly = true)
	public Movie findByID(String movieId) {
		Movie movie = movieRepository.findByID(movieId);
		if (movie == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return movie;
	}
	
}
