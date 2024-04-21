package com.inditex.task.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.persistence.NoResultException;
import lombok.NoArgsConstructor;

@RestControllerAdvice
@NoArgsConstructor
public class CustomExceptionHandler {
    
    @ExceptionHandler(value = {NoResultException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ErrorMessage handleNoResultException (RuntimeException ex, WebRequest request) {
        String message = "price not_found";
        String description = "no price was found with requested params";
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), message, description);
    }
}
