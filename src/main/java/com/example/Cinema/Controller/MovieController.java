package com.example.Cinema.Controller;

import com.example.Cinema.Model.Movie;
import com.example.Cinema.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getAMovieById(@PathVariable("id")Long id){
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

}
