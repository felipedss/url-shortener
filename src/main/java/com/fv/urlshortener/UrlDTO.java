package com.fv.urlshortener;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class UrlDTO {

    @NotBlank
    private String longUrl;

    private LocalDate expirationDate;

}
