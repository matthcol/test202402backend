package org.example.movieapi.utils;

import org.example.movieapi.dto.MovieDetail;
import org.example.movieapi.dto.PersonSimple;
import org.example.movieapi.enums.ColorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.movieapi.utils.PersonSimpleFactory.*;

public class MovieDetailFactory {

    public static MovieDetail of(int id, String name, short year, Short duration, String synopsis, ColorType colorType){
        var movieDetail = new MovieDetail();
        movieDetail.setId(id);
        movieDetail.setName(name);
        movieDetail.setYear(year);
        movieDetail.setDuration(duration);
        movieDetail.setSynopsis(synopsis);
        movieDetail.setColorType(colorType);
        return movieDetail;
    }

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

    public static String movieJsonFrom(Integer id, String name, Short year, Short duration, String synopsis, ColorType colorType){
        var builder = new StringBuilder();
        builder.append("{");
        var jsonProperties = new ArrayList<String>();
        if (Objects.nonNull(id)) jsonProperties.add("\"id\": " + id);
        if (Objects.nonNull(name)) jsonProperties.add("\"name\": \"" + name + '"');
        if (Objects.nonNull(year)) jsonProperties.add("\"year\": " + year);
        if (Objects.nonNull(duration)) jsonProperties.add("\"duration\": " + duration);
        if (Objects.nonNull(synopsis)) jsonProperties.add("\"synopsis\": \"" + synopsis + '"');
        if (Objects.nonNull(colorType)) jsonProperties.add("\"colorType\": \"" + colorType + '"');
        builder.append(String.join(", ", jsonProperties));
        return builder.append("}")
                .toString();
    }
}
