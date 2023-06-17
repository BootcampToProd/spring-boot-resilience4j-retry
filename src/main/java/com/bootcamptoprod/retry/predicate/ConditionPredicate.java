package com.bootcamptoprod.retry.predicate;

import com.bootcamptoprod.retry.entity.Movie;

import java.util.function.Predicate;

public class ConditionPredicate implements Predicate<Movie> {
    @Override
    public boolean test(Movie movie) {
        System.out.println("Condition predicate is called.");
        return movie.getId().equals("Default");
    }
}
