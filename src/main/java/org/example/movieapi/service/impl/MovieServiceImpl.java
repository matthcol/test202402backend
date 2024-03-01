package org.example.movieapi.service.impl;

import org.example.movieapi.dto.MovieCreate;
import org.example.movieapi.dto.MovieSimple;
import org.example.movieapi.entity.MovieEntity;
import org.example.movieapi.repository.MovieRepository;
import org.example.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //@Autowired
    private ModelMapper modelMapper;

//    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
//        this.movieRepository = movieRepository;
//        this.modelMapper = modelMapper;
//    }


    @Autowired
    public MovieServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MovieSimple add(MovieCreate movieCreate) {
        var movieEntity = modelMapper.map(movieCreate, MovieEntity.class);
        var movieEntitySaved = movieRepository.save(movieEntity);
        return modelMapper.map(movieEntitySaved, MovieSimple.class);
    }
}
