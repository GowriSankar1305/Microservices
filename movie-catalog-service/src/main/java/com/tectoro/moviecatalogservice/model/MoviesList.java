package com.tectoro.moviecatalogservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesList implements Serializable {

	private static final long serialVersionUID = -4995698593737165777L;
	
	private List<MovieModel> movies;

	public List<MovieModel> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieModel> movies) {
		this.movies = movies;
	}
}
