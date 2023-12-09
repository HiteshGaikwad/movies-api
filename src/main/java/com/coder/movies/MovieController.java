package com.coder.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        Optional<Movie> movie= movieService.getMovie(imdbId);
        return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
    }
}
