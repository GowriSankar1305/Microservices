package com.tectoro.moviecatalogservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingModel implements Serializable {

	private static final long serialVersionUID = 4634918222118921221L;
	
	private long movieId;
	private int rating;
	
	public RatingModel()	{
		
	}
	
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public RatingModel(long movieId, int rating) {
		this.movieId = movieId;
		this.rating = rating;
	}
}
