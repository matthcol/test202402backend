package org.example.movieapi.handler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class DataAccesExceptionHandler {

    @ResponseStatus(
            value= HttpStatus.CONFLICT,
            reason = "Data persistence conflict"
    )
    @ExceptionHandler(DataAccessException.class)
    public void handleDataAccessException(){
    }
}
