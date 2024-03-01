package org.example.movieapi.service.impl;

import org.example.movieapi.dto.MovieCreate;
import org.example.movieapi.dto.MovieSimple;
import org.example.movieapi.entity.MovieEntity;
import org.example.movieapi.repository.MovieRepository;
import org.example.movieapi.service.MovieService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {

    // componeent to test
    @InjectMocks()
    MovieServiceImpl movieService;

    @BeforeEach
    void  setup(){
        MockitoAnnotations.openMocks(this);
    }
    // componentt dependencies
    @Mock
    ModelMapper modelMapper;

    @Mock
    MovieRepository movieRepository;

    @Test
    void testAdd(){
        int id = 123;
        String name = "Dune: Part Two";
        short year = 2024;
        // prepare mocks
        // mock1: repository
        var movieEntityRepositoryResponse = new MovieEntity();
        movieEntityRepositoryResponse.setId(id);
        movieEntityRepositoryResponse.setName(name);
        movieEntityRepositoryResponse.setYear(year);
        BDDMockito.when(movieRepository.save(BDDMockito.any()))
                .thenReturn(movieEntityRepositoryResponse);

        // mock2: modelmapper
        var movieSimpleModelMapperResponse = new MovieSimple();
        movieSimpleModelMapperResponse.setId(id);
        movieSimpleModelMapperResponse.setName(name);
        movieSimpleModelMapperResponse.setYear(year);
        var movieEntityModelMapperResponse = new MovieEntity();
        movieEntityModelMapperResponse.setName(name);
        movieEntityModelMapperResponse.setYear(year);

        // BDDMockito.when(modelMapper.map(movieEntityResponse, MovieSimple.class))
        BDDMockito.when(modelMapper.map(BDDMockito.any(), BDDMockito.any()))
                .thenReturn(movieEntityModelMapperResponse)
                .thenReturn(movieSimpleModelMapperResponse);

        // BDDMockito.when(modelMapper.map(BDDMockito.any(), BDDMockito.eq(MovieEntity.class))
        //        .thenReturn(movieSimpleResponse);


        // data
        var movieCreate = new MovieCreate();
        movieCreate.setName(name);
        movieCreate.setYear(year);

        // when call method
        var actualMovieSimple = movieService.add(movieCreate);
        assertAll(
                () -> assertEquals(actualMovieSimple.getId(), id),
                () -> assertEquals(actualMovieSimple.getName(), name),
                () -> assertEquals(actualMovieSimple.getYear(), year)
        );

        // verify mocks have been called
        BDDMockito.then(movieRepository)
                .should()
                .save(BDDMockito.any());

        Mockito.verify(modelMapper, BDDMockito.times(2))
                .map(BDDMockito.any(), BDDMockito.any());
    }

}