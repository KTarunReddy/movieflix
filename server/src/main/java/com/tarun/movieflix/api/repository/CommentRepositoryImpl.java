package com.tarun.movieflix.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tarun.movieflix.api.entity.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comment create(Comment comment) {
     	em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		em.remove(comment);
	}

	@Override
	public List<Comment> findAllComments(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAllComments", Comment.class);
		query.setParameter("cid", movieId);
		List<Comment> list = query.getResultList();
		return list ;
	}

	@Override
	public Comment findByID(String commentId) {
    	return em.find(Comment.class, commentId);
	}
}
