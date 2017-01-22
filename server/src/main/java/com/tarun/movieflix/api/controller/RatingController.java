package com.tarun.movieflix.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.movieflix.api.entity.Rating;
import com.tarun.movieflix.api.service.RatingService;
	
@RestController
@RequestMapping(value = "ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(method = RequestMethod.GET, value="{videoId}")
	public double findAvgRatings(@PathVariable("videoId") String videoId){
		return ratingService.findAvgRatings(videoId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{ratingId}")
	public void delete(@PathVariable("ratingId") String ratingId){
		ratingService.delete(ratingId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{ratingId}/rating={rate}")
	public Rating update(@PathVariable("ratingId") String ratingId, @PathVariable("rate") double rate){
    	return ratingService.update(ratingId, rate);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="{videoId}/{userId}/rating={rate}")
	public Rating create(@PathVariable("videoId") String videoId, @PathVariable("userId") String userId, @PathVariable("rate") double rate){
		return ratingService.create(videoId, userId, rate);
	}
}
