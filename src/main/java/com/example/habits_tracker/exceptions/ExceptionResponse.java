package com.example.habits_tracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse extends Throwable {

    private HttpStatus status;

    private String exceptionName;

    private String message;

}
