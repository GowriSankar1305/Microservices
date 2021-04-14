package com.tectoro.ratingsdataservice.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.ratingsdataservice.model.RatingModel;
import com.tectoro.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata/")
public class DataServiceController {
	
	@GetMapping
	public String getDefault()	{
		return "<h1>Welcome to ratings data service</h1>";
	}
	
	@GetMapping("{movieId}")
	public RatingModel getRating(@PathVariable(name = "movieId") long movieId)	{
		return new RatingModel(1, 5);
	}
	
	@GetMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable long userId)	{
		UserRating userRating = new UserRating();
		userRating.setRatings(Arrays.asList(
				 new RatingModel(1, 5)
				,new RatingModel(2, 4)
				,new RatingModel(3, 5)
				,new RatingModel(4, 4)
				,new RatingModel(5, 5))
		);
		return userRating;
	}
}
