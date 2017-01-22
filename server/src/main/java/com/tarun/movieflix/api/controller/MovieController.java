package com.tarun.movieflix.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.movieflix.api.entity.Movie;
import com.tarun.movieflix.api.service.MovieService;

@RestController
@RequestMapping(value = "movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll(){
		return movieService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{title}")
	public Movie findByTitle(@PathVariable("title") String title) {
		return movieService.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "search={title}")
	public List<Movie> findByTitleSubstring(@PathVariable("title") String title) {
		return movieService.findByTitleSubstring(title);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "top={type}")
	public List<Movie> findTopRatedMovies(@PathVariable("type") String type){
		return movieService.findTopRatedMovies(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "type={type}/year={year}/genre={genre}/sort={sort}")
	public List<Movie> findByFilter(@PathVariable("type")String type, @PathVariable("year")int year, @PathVariable("genre")String genre, @PathVariable("sort") String sort){
		return movieService.findByFilter(type, year, genre, sort);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getimdb/{title}")
	public String getImdbID(@PathVariable("title") String title){
		return movieService.getImdbID(title);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{title}")
    public void delete(@PathVariable("title") String title){
		movieService.delete(title);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{title}")
	public Movie update(@PathVariable("title") String title, @RequestBody Movie movie){
		return movieService.update(title, movie);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie){
		return movieService.create(movie);
	}
}
