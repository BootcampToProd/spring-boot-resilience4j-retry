package com.bootcamptoprod.retry.controller.mock;

import com.bootcamptoprod.retry.entity.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock/movies")
public class MockMovieController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable String id) {
        Movie movie = null;
        switch (id) {
            case "1" -> movie = new Movie("1", "The Matrix", "Lana Wachowski, Lilly Wachowski", 8.7);
            case "2" -> movie = new Movie("2", "Inception", "Christopher Nolan", 8.8);
            case "3" -> {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found");
            }
        }
        return ResponseEntity.ok(movie);
    }
}

