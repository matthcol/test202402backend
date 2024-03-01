package org.example.movieapi.service;

import org.example.movieapi.dto.MovieCreate;
import org.example.movieapi.dto.MovieSimple;
import org.springframework.dao.DataAccessException;

public interface MovieService {

    /**
     * Add a valid movie in a persistence area (database, file, cloud, ...)
     * @param movie valid movie
     * @return movie with generated id
     * @throws DataAccessException when data persistence fails
     */
    MovieSimple add(MovieCreate movie);
}
