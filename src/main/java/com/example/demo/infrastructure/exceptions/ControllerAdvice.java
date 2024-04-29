package com.example.demo.infrastructure.exceptions;

import com.example.demo.infrastructure.web.rest.dto.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> validHandlerException(MethodArgumentNotValidException e){
        HttpResponse httpResponse = HttpResponse
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
        return new ResponseEntity<>(httpResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoDataExists.class)
    public ResponseEntity<HttpResponse> validHandlerException(NoDataExists e){
        HttpResponse httpResponse = HttpResponse
                .builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();
        return new ResponseEntity<>(httpResponse, HttpStatus.NO_CONTENT);
    }
}
