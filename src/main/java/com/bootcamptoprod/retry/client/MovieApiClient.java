package com.bootcamptoprod.retry.client;

import com.bootcamptoprod.retry.entity.Movie;
import com.bootcamptoprod.retry.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public Movie getMovieDetails(String movieId) throws MovieNotFoundException {
        String url = "http://localhost:8080/mock/movies/" + movieId;
        Movie movie = restTemplate.getForObject(url, Movie.class);
        if (movie == null) {
            throw new MovieNotFoundException("Movie with id " + movieId + " not found.");
        }
        return movie;
    }
}