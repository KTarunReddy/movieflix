package com.tarun.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tarun.movieflix.api.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.selectAllSortByYear",Movie.class);
		List<Movie> list = query.getResultList();
		return list ;
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle",Movie.class);
		query.setParameter("mtitle", title);
	   
		List<Movie> movie = query.getResultList();
		if(movie.size() == 1) {
			return movie.get(0);		  
		}
		else{
			return null;
		}
	}
	
	@Override
	public List<Movie> findByTitleSubstring(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle",Movie.class);
		query.setParameter("mtitle", "%" + title + "%");
		List<Movie> list = query.getResultList();
		return list ;
	}

	@Override
	public List<Movie> findTopRatedMovies(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.selectTopRated",Movie.class);
		query.setParameter("mtype", type);
		query.setMaxResults(10);
		List<Movie> list = query.getResultList();
		return list ;
	}

	@Override
	public List<Movie> findByFilter(String type, int year, String genre, String sort) {
		TypedQuery<Movie> query =null;
	
		if(type.equals("null") && year == 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectAllSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectAllSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectAllSortByYear",Movie.class);
		}
		else if(type.equals("null") && year == 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByGenreSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByGenreSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByGenreSortByYear",Movie.class);
			
			query.setParameter("mgenre", "%" + genre + "%");
		}
		else if(type.equals("null") && year != 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByYearSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByYearSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByYearSortByYear",Movie.class);
			
			query.setParameter("myear", year);
		}
		else if(type.equals("null") && year != 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByYearGenreSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByYearGenreSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByYearGenreSortByYear",Movie.class);
		
			query.setParameter("myear", year);
			query.setParameter("mgenre", "%" + genre + "%");
		}
		else if(!type.equals("null") && year == 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByTypeSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByTypeSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByTypeSortByYear",Movie.class);
		
			query.setParameter("mtype", type);
		}
		else if(!type.equals("null") && year == 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByTypeGenreSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByTypeGenreSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByTypeGenreSortByYear",Movie.class);
			
			query.setParameter("mtype", type);
			query.setParameter("mgenre", "%" + genre + "%");
		}
		else if(!type.equals("null") && year != 0 && genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByTypeYearSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByTypeYearSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByTypeYearSortByYear",Movie.class);
		
			query.setParameter("mtype", type);
			query.setParameter("myear", year);
		}
		else if(!type.equals("null") && year != 0 && !genre.equals("null"))
		{
			if(sort.equals("imdbRating"))
				 query = em.createNamedQuery("Movie.selectByTypeYearGenreSortByRating",Movie.class);	
			else if(sort.equals("imdbVotes"))
				 query = em.createNamedQuery("Movie.selectByTypeYearGenreSortByVotes",Movie.class);
			else
				 query = em.createNamedQuery("Movie.selectByTypeYearGenreSortByYear",Movie.class);
		
			query.setParameter("mtype", type);
			query.setParameter("myear", year);
			query.setParameter("mgenre", "%" + genre + "%");
		}
		List<Movie> list = query.getResultList();
		return list ;
	}
	
	@Override
	public String getImdbID(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle",Movie.class);
		query.setParameter("mtitle", title);
		List<Movie> movie = query.getResultList();
		if(movie.size() == 1) {
			return movie.get(0).getImdbId();		  
		}
		else{
			return null;
		}
	}

	@Override
	public Movie findByID(String movieId) {
		return em.find(Movie.class, movieId);
	}
	
}
