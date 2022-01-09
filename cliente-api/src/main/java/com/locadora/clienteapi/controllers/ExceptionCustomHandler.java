package com.locadora.clienteapi.controllers;

import com.locadora.clienteapi.models.ErrorResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.logging.ErrorManager;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionCustomHandler {
    private static final String CONTENT_TYPE =  "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";
    private ErrorManager log;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(final MethodArgumentNotValidException ex) {
        final BindingResult bindingResult = ex.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        final ErrorResponse message = processFieldErrors(fieldErrors);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse processFieldErrors(final List<FieldError> fieldErrors) {
        final List<String> errors =
                fieldErrors.stream()
                        .map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage()))
                        .collect(Collectors.toList());
        return new ErrorResponse(errors);
    }
}