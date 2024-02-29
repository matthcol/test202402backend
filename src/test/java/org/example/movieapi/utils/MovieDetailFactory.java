package org.example.movieapi.utils;

import org.example.movieapi.dto.MovieDetail;
import org.example.movieapi.dto.PersonSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.movieapi.utils.PersonSimpleFactory.*;

public class MovieDetailFactory {

    public static MovieDetail movieDetailWithActors() {
        var movieDetail =  new MovieDetail();
        movieDetail.setId(19870);
        movieDetail.setName("Dune: Part V");
        movieDetail.setYear((short) 2033);
        var actors = new ArrayList<PersonSimple>();
        actors.add(personKevinSpacey());
        movieDetail.setActors(actors);
        return movieDetail;
    }

    public static Stream<List<PersonSimple>> provideActors(){
        return Stream.of(
          List.of(),
          List.of(
                  personKevinSpacey()
          ),
          List.of(
                  personKevinSpacey(),
                  personKeanuReeves(),
                  personClintEastwood()
          )
        );
    }

    public static Stream<MovieDetail> provideMovieWithOrWithoutActors(){
        return Stream.of(
                new MovieDetail(),
                movieDetailWithActors()
        );
    }
}
