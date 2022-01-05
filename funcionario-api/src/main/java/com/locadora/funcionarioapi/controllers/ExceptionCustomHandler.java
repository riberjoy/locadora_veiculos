package com.locadora.funcionarioapi.controllers;


import com.locadora.funcionarioapi.models.ErrorResponse;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice

public class ExceptionCustomHandler {
    private static final String CONTENT_TYPE =  "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(final MethodArgumentNotValidException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errorResponse.adicionarError(
                    fieldError.getField() + ": " + fieldError.getDefaultMessage()
            );
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
