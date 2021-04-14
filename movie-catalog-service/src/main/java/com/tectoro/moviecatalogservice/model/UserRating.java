package com.tectoro.moviecatalogservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRating implements Serializable {

	private static final long serialVersionUID = -2804687348863545639L;
	
	private List<RatingModel> ratings;

	public List<RatingModel> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingModel> ratings) {
		this.ratings = ratings;
	}
}
