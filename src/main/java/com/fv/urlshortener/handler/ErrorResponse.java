package com.fv.urlshortener.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final String details;

    public static ErrorResponse of(String details) {
        return new ErrorResponse(details);
    }

}
