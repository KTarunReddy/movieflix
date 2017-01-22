package com.tarun.movieflix.api.repository;

import java.util.List;

import com.tarun.movieflix.api.entity.Comment;

public interface CommentRepository {

	Comment create(Comment comment);

	Comment findByID(String commentId);

	Comment update(Comment comment);

	void delete(Comment comment);

	List<Comment> findAllComments(String movieId);

}
