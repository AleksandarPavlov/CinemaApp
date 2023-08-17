package com.example.Cinema.Service;

import com.example.Cinema.Model.Movie;
import com.example.Cinema.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplement implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
