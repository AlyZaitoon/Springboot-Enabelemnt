package com.example.demo.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId,5);
	}
	@GetMapping("/user/{userId}")
	public List<Rating> getUserRatings(@PathVariable String userId){
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 3)
				);
		return ratings;
	}
}
