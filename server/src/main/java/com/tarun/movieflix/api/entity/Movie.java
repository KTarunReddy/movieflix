package com.tarun.movieflix.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Movie.selectAllSortByVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByTypeSortByVotes", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByYearSortByVotes", query = "SELECT m FROM Movie m WHERE m.year = :myear ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByGenreSortByVotes", query = "SELECT m FROM Movie m WHERE m.genre LIKE :mgenre ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByTypeGenreSortByVotes", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.genre LIKE :mgenre ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearSortByVotes", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByYearGenreSortByVotes", query = "SELECT m FROM Movie m WHERE m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearGenreSortByVotes", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.imdbvotes DESC"),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE UPPER(m.title) LIKE UPPER(:mtitle)"),
	@NamedQuery(name = "Movie.selectTopRated", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectAllSortByRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByTypeSortByRating", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByYearSortByRating", query = "SELECT m FROM Movie m WHERE m.year = :myear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByGenreSortByRating", query = "SELECT m FROM Movie m WHERE m.genre LIKE :mgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByTypeGenreSortByRating", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.genre LIKE :mgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearSortByRating", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByYearGenreSortByRating", query = "SELECT m FROM Movie m WHERE m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearGenreSortByRating", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.imdbRating DESC"),	
	@NamedQuery(name = "Movie.selectAllSortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByTypeSortByYear", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByYearSortByYear", query = "SELECT m FROM Movie m WHERE m.year = :myear ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByGenreSortByYear", query = "SELECT m FROM Movie m WHERE m.genre LIKE :mgenre ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByTypeGenreSortByYear", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.genre LIKE :mgenre ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearSortByYear", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByYearGenreSortByYear", query = "SELECT m FROM Movie m WHERE m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.selectByTypeYearGenreSortByYear", query = "SELECT m FROM Movie m WHERE m.type LIKE :mtype AND m.year = :myear AND m.genre LIKE :mgenre ORDER BY m.year DESC")			
})
public class Movie {

	@Id
	private String movieId;
	@Column(unique=true)
	private String title;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metaScore;
	private double imdbRating;
	private int imdbvotes;
	private String imdbId;
	private String type;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public int getimdbvotes() {
		return imdbvotes;
	}

	public void setimdbvotes(int imdbvotes) {
		this.imdbvotes = imdbvotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getmovieId() {
		return movieId;
	}

	public void setmovieId(String movieId) {
		this.movieId = movieId;
	}

	public Movie() {
		this.movieId = UUID.randomUUID().toString();
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metaScore=" + metaScore + ", imdbRating="
				+ imdbRating + ", imdbvotes=" + imdbvotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}

}
