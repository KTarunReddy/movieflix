package com.tarun.movieflix.api.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarun.movieflix.api.entity.Comment;
import com.tarun.movieflix.api.entity.User;
import com.tarun.movieflix.api.entity.Movie;
import com.tarun.movieflix.api.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private MovieService movieService;
		
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public Comment create(String movieId, String userId, String comment_str) {
		Movie movie = movieService.findByID(movieId);
		User user = userService.findByID(userId);
		Comment comment = new Comment();
		comment.setMovie(movie);
		comment.setUser(user);
		comment.setComment(comment_str);
		return commentRepository.create(comment);
	}

	@Override
	@Transactional
	public Comment update(String commentId, String comment_str) {
		Comment comment = commentRepository.findByID(commentId);
		if (comment == null) {
			throw new EntityNotFoundException("Comment not found");
		}
	
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		comment.setDate(df.format(dateobj));
		comment.setComment(comment_str);
		return commentRepository.update(comment);
	}

	@Override
	@Transactional
	public void delete(String commentId) {
		Comment comment = commentRepository.findByID(commentId);
		if (comment == null) {
			throw new EntityNotFoundException("Comment not found");
		}
    	commentRepository.delete(comment);
	}
	
	@Override
	public List<Comment> findAllComments(String movieId) {
		return commentRepository.findAllComments(movieId);
	}

}
