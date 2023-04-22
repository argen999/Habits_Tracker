package com.example.habits_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestHandler(BadRequestException badRequestException) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST,
                badRequestException.getClass().getSimpleName(),
                badRequestException.getMessage()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse badRequestHandler(NotFoundException notFoundException) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND,
                notFoundException.getClass().getSimpleName(),
                notFoundException.getMessage()
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse badRequestHandler(BadCredentialsException badCredentialsException) {
        return new ExceptionResponse(HttpStatus.FORBIDDEN,
                badCredentialsException.getClass().getSimpleName(),
                badCredentialsException.getMessage()
        );
    }

}
