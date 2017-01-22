package com.tarun.movieflix.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.movieflix.api.entity.Comment;
import com.tarun.movieflix.api.service.CommentService;

@RestController	
@RequestMapping(value = "comments")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(method = RequestMethod.GET, value="{videoId}")
	public List<Comment> findAllComments(@PathVariable("videoId") String videoId){
		return commentService.findAllComments(videoId);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="{videoId}/{userId}/comment={comment_str}")
	public Comment create(@PathVariable("videoId") String videoId, @PathVariable("userId") String userId, @PathVariable("comment_str") String comment_str){
		return commentService.create(videoId, userId, comment_str);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{commentId}/comment={comment_str}")
	public Comment update(@PathVariable("commentId") String commentId, @PathVariable("comment_str") String comment_str){
		return commentService.update(commentId, comment_str);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="{commentId}")
	public void delete(@PathVariable("commentId") String commentId){
		commentService.delete(commentId);
	}
}
