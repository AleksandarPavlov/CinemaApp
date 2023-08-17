package com.example.Cinema.Service;

import com.example.Cinema.Model.Movie;

import java.util.List;

public interface MovieService {
    public Movie createMovie(Movie movie);
    public List<Movie> getAllMovies();
}
