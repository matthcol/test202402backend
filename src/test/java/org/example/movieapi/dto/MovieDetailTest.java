package org.example.movieapi.dto;

import org.example.movieapi.utils.MovieDetailFactory;
import org.example.movieapi.utils.PersonSimpleFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MovieDetailTest {

    @Test
    void testDirector(){
        fail();
    }

    @ParameterizedTest
    @MethodSource("org.example.movieapi.utils.MovieDetailFactory#provideActors")
    void testActors(List<PersonSimple> givenActors){
        var movie = new MovieDetail();
        // when
        movie.setActors(givenActors);
        var actualActors = movie.getActors();
        // then
        assertNotNull(actualActors);
        assertEquals(givenActors.size(), actualActors.size(), "actors size");
        assertAll(givenActors
                .stream()
                .map(
                    givenActor -> () -> assertTrue(
                            actualActors.contains(givenActor),
                            MessageFormat.format("actor <{0}> in movie actors", givenActor.getName())
                    )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("org.example.movieapi.utils.MovieDetailFactory#provideMovieWithOrWithoutActors")
    void testActors_add(MovieDetail givenMovie){
        // when
        givenMovie.getActors().add(PersonSimpleFactory.personKeanuReeves());
    }

    @Test
    void testActors_remove(){
        fail();
    }


}