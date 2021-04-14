package com.tectoro.movieinfoservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.movieinfoservice.model.MovieModel;

@RestController
@RequestMapping("/movies/")
public class InfoServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(InfoServiceController.class);
	
	@GetMapping
	public String getDefault()	{
		return "<h1>Welcome to movie info service</h1>";
	}
	
	@GetMapping("{movieIds}")
	public List<MovieModel> getMoviesInfo(@PathVariable(name = "movieIds") List<Long> movieIds)	{
		logger.info("********************* Start of InfoServiceController.getMoviesInfo ******************");
		List<MovieModel> moviesList = null;
		if(CollectionUtils.isEmpty(movieIds))	{
			return null;
		}
		logger.info("movieIds-----------> {}",movieIds);
		logger.info("********************* End of InfoServiceController.getMoviesInfo ******************");
		moviesList = getMoviesMap().entrySet().stream()
				.filter(map -> movieIds.contains(map.getKey()))
				.map(item -> item.getValue()).collect(Collectors.toList());
		logger.info("movieslist---------------> {}",moviesList);
		return moviesList;
	}
	
	private Map<Long, MovieModel> getMoviesMap()	{
		Map<Long, MovieModel> moviesMap = new HashMap<Long, MovieModel>();
		moviesMap.put((long) 1, new MovieModel(1,"Ala vaikuntapuramuloo", "Allu arjun,pooja hegde,trivikram,thaman"));
		moviesMap.put((long) 2, new MovieModel(2,"Naa peru surya naa illu india", "Allu arjun,amu immanuel,vakkantam vamsi,rishi punjabi"));
		moviesMap.put((long) 3, new MovieModel(3,"Duvvada jagannadam", "Allu arjun,pooja hegde,harish shankar,Dsp"));
		moviesMap.put((long) 4, new MovieModel(4,"Sarrainodu", "Allu arjun,rakul preet,Boyapati sreenu,thaman"));
		moviesMap.put((long) 5, new MovieModel(5,"S/O satyamurthy", "Allu arjun,samantha,trivikram,Dsp"));
		moviesMap.put((long) 6, new MovieModel(6,"Race gurram", "Allu arjun,Shruti hassan,Surendar reddy,thaman"));
		moviesMap.put((long) 7, new MovieModel(7,"Iddarammayilatho", "Allu arjun,atherine teresa,Puri jagannath,Dsp"));
		moviesMap.put((long) 8, new MovieModel(8,"Julayi", "Allu arjun,Ileyana,trivikram,Dsp"));
		
		return moviesMap;
	}
}
