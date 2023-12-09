package com.coder.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Optional<List<Review>>> getReviewsByimdbId(@PathVariable String imdbId){
        Optional<List<Review>> reviewsList= reviewService.getReviews(imdbId);
        return new ResponseEntity<>(reviewsList, HttpStatus.FOUND);
    }
}
