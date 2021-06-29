package com.fv.urlshortener;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UrlController {

    private final UrlService urlService;

    @PostMapping
    @Operation(summary = "Convert new url", description = "Converts long url to short url")
    public ResponseEntity<Url> shorten(@RequestBody UrlDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(urlService.shorten(dto));
    }

    @Operation(summary = "Redirect", description = "Finds original url from short url and redirects")
    @GetMapping(path = "{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable("shortUrl") String shortUrl) {
        final String originalUrl = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }

}
