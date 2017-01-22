package com.tarun.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tarun.movieflix.api.entity.Rating;

@Repository
public class RatingRepositoryImpl implements RatingRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}

	@Override
	public Rating update(Rating rating) {
    	return em.merge(rating);
	}

	@Override
	public void delete(Rating rating) {
		em.remove(rating);
	}

	@Override
	public double findAvgRatings(String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAvgRatings", Rating.class);
		query.setParameter("cid", movieId);
		List<Rating> list = query.getResultList();
		if(list.size() > 0){
			double sum = 0.0;
			for(int i=0;i<list.size();i++)
				sum += list.get(i).getRating();
			double average = sum/list.size();
			return average;
		}
		else
			return 0;
	}
	
	@Override
	public Rating findByID(String ratingId) {
		return em.find(Rating.class, ratingId);
	}

}

