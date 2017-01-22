package com.tarun.movieflix.api.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Comment.findAllComments",query = "SELECT c from Comment c INNER JOIN c.movie m WHERE m.movieId = :cid")
})
public class Comment {
	
	@Id
	private String commentId;
	private String comment;
	@ManyToOne
    private User user;
	@ManyToOne
    private Movie movie;
	private String date;

	public String getCommentId() {
		return commentId;
	}
	
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Comment(){
		this.commentId = UUID.randomUUID().toString();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		this.date = df.format(dateobj);
	}
}
