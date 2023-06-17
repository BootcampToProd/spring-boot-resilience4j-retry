package com.bootcamptoprod.retry.controller;

import com.bootcamptoprod.retry.entity.Movie;
import com.bootcamptoprod.retry.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id, @RequestParam(defaultValue = "simple-retry") String retryType) {
        switch (retryType) {
            case "simple-retry" -> {
                log.info("Simple retry example");
                Movie movie = movieService.getMovieDetails(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-on-exception" -> {
                log.info("Retry on configured exceptions example");
                Movie movie = movieService.getMovieDetailsRetryOnException(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-on-exception-predicate" -> {
                log.info("Retry on exception predicate example");
                Movie movie = movieService.getMovieDetailsRetryOnExceptionPredicate(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-on-conditional-predicate" -> {
                log.info("Retry on conditional predicate example");
                Movie movie = movieService.getMovieDetailsRetryOnConditionalPredicate(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-using-exponential-backoff" -> {
                log.info("Retry using exponential backoff example");
                Movie movie = movieService.getMovieDetailsRetryUsingExponentialBackoff(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-using-randomized-wait" -> {
                log.info("Retry using randomized wait example");
                Movie movie = movieService.getMovieDetailsRetryUsingRandomizedWait(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-with-fallback" -> {
                log.info("Retry with fallback example");
                Movie movie = movieService.getMovieDetailsWithFallback(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-with-custom-config" -> {
                log.info("Retry with custom config example");
                Movie movie = movieService.getMovieDetailsWithCustomRetryConfig(id);
                return ResponseEntity.ok(movie);
            }
            case "retry-with-event-details" -> {
                log.info("Retry with event details example");
                Movie movie = movieService.getMovieDetailsWithRetryEventDetails(id);
                return ResponseEntity.ok(movie);
            }
        }
        return null;
    }
}
