package com.fv.urlshortener.handler;

import com.fv.urlshortener.UrlShortenerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UrlShortenerException.class)
    protected ResponseEntity<Object> handleUrlShortException(UrlShortenerException urlShortenerException) {
        ErrorResponse error = ErrorResponse.of(urlShortenerException.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
