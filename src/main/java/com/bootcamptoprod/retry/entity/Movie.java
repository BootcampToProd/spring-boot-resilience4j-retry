package com.bootcamptoprod.retry.entity;

public class Movie {
    private String id;
    private String title;
    private String director;
    private double rating;

    public Movie(String id, String title, String director, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

