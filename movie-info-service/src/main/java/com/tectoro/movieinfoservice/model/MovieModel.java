package com.tectoro.movieinfoservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel implements Serializable {

	private static final long serialVersionUID = 1823801163674750623L;
	
	private long movieId;
	private String movieName;
	private String movieDescription;
	
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public MovieModel(long movieId, String movieName,String desc) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = desc;
	}
}
