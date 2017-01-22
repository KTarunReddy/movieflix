package com.tarun.movieflix.api.service;

import java.util.List;

import com.tarun.movieflix.api.entity.Comment;
	
public interface CommentService {

	Comment create(String movieId, String userId, String comment_str);

	Comment update(String commentId, String comment_str);

	void delete(String commentId);

	List<Comment> findAllComments(String movieId);
	
}
