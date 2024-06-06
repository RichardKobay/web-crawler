package edu.upvictoria;

import java.util.List;

public class Movie {
    private String title;
    private String year;
    private String rating;
    private List<String> director;
    private List<String> writers;
    private List<String> genre;
    private List<String> actors;

    public Movie (String title, String year, String rating, List<String> director, List<String> writers, List<String> genre, List<String> actors) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.director = director;
        this.writers = writers;
        this.genre = genre;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getDirector() {
        return director;
    }

    public void setDirector(List<String> director) {
        this.director = director;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}
