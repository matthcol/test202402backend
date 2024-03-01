package org.example.movieapi.controller;

import org.example.movieapi.dto.MovieCreate;
import org.example.movieapi.dto.MovieSimple;
import org.example.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController implements MovieControllerApi {

    @Autowired
    private MovieService movieService;

    @Override
    public MovieSimple add(@RequestBody MovieCreate movie) {
        // throw new UnsupportedOperationException("Not implemented yet");
        // return null;
        return movieService.add(movie);
    }
}
