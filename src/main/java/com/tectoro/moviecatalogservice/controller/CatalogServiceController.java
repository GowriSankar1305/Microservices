package com.tectoro.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tectoro.moviecatalogservice.model.CatalogItem;
import com.tectoro.moviecatalogservice.model.MovieModel;
import com.tectoro.moviecatalogservice.model.RatingModel;
import com.tectoro.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog/")
public class CatalogServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogServiceController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String getDefault()	{
		return "<h1>Welcome to movie catalog service</h1>";
	}
	
	@GetMapping("{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(name = "userId") long userId)	{
		logger.info("************************** Start of CatalogServiceController.getCatalog ***********************");
		List<CatalogItem> catalogList = new ArrayList<CatalogItem>();
		
		ResponseEntity<UserRating> response = restTemplate.getForEntity("http://localhost:9092/ratingsdata/users/" + userId, UserRating.class);
		UserRating userRating = response.getBody();
		
		Map<Long,Integer> ratingsMap = userRating.getRatings().stream().collect(Collectors.toMap(RatingModel::getMovieId, RatingModel::getRating));
		
		String url = "http://localhost:9090/movies/" + ratingsMap.entrySet().stream().map(rating -> String.valueOf(rating.getKey()))
																					.collect(Collectors.joining(","));
		ResponseEntity<MovieModel[]> moviesList = restTemplate.getForEntity(url, MovieModel[].class); 
		for(MovieModel item : moviesList.getBody())	{
			catalogList.add(new CatalogItem(item.getMovieName(), 
					item.getMovieDescription(), ratingsMap.get(item.getMovieId()) ));
		}
		logger.info("************************** End of CatalogServiceController.getCatalog ***********************");
		return catalogList;
	}
}
