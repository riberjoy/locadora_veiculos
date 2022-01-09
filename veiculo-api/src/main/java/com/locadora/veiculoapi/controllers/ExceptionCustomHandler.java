package com.locadora.veiculoapi.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.locadora.veiculoapi.models.ErrorResponse;
import com.locadora.veiculoapi.models.FeignResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ExceptionCustomHandler {
    private static final String CONTENT_TYPE =  "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @ExceptionHandler(FeignException.class)
    public HttpEntity handleFeignStatusException(FeignException e, HttpServletResponse response) {
        try {
            Gson gson = new GsonBuilder().setLenient().create();

            String[] errorMessage = e.getMessage().split("]: ");
            FeignResponse[] feignResponse = gson.fromJson(errorMessage[1], FeignResponse[].class);

            response.setStatus(feignResponse[0].getStatus());
            response.setHeader(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);

            return new ResponseEntity(feignResponse[0].getMessage(), HttpStatus.valueOf(feignResponse[0].getStatus()));
        } catch (Exception er){
            log.error(er.getMessage());
            return new ResponseEntity<>(e.getMessage(), null, null);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ErrorResponse> handlerValidationException(final MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);

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
