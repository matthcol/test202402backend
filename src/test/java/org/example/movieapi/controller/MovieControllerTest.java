package org.example.movieapi.controller;

import org.example.movieapi.dto.MovieDetail;
import org.example.movieapi.enums.ColorType;
import org.example.movieapi.service.MovieService;
import org.example.movieapi.utils.MovieDetailFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(MovieController.class)
class MovieControllerTest {

    private final static String BASE_URL = "/api/movie";

    @MockBean
    MovieService movieService;

    @Autowired
    MockMvc httpClient;

    @ParameterizedTest
    @CsvSource({
            "Dune,2020,,,",
            "Dune,2020,120,,",
            "Dune,2020,,Great sci-fi movie,",
            "Dune,2020,,,COLOR",
            // ...
            "Dune,2020,120,Great sci-fi movie,BLACK_AND_WHITE"
    })
    void testAdd_valid(String name, Short year, Short duration, String synopsis, ColorType colorType) throws Exception {
        // prepare mock
        int id = 782; // or random number
        var movieMockResponse = MovieDetailFactory.of(id, name, year, duration, synopsis, colorType);
        BDDMockito.given(movieService.add(ArgumentMatchers.any()))
                        .willReturn(movieMockResponse);
        // prepare json to post
        var movieRequest = MovieDetailFactory.movieJsonFrom(null, name, year, duration, synopsis, colorType);

        // when
        httpClient.perform(MockMvcRequestBuilders.post(BASE_URL)
                .content(movieRequest)
                                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                )
                // handle result
                .andDo(MockMvcResultHandlers.print())
                // verify result
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
        ;

        // verify mock has been called
        BDDMockito.then(movieService)
                .should()
                .add(BDDMockito.any());
    }

    // void testAdd_notvalid
    // pb type on not str fields (int, enum, [localdate])
    // pb vaiid: title length between 1 and 300, year >= 1888, title, year mandatory, other nullables
    // => HTTP status 400 bad request
    // mock has not been called

    // void testAdd_ DAO exception: DataAccessException
    // mockservice throws DataAccessException => HTTP status Conflict 409


}