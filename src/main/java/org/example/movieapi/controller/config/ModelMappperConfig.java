package org.example.movieapi.controller.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappperConfig {

    @Bean
    public ModelMapper modelMapper(){
        // NB: tune your mapper here
        return new ModelMapper();
    }
}
