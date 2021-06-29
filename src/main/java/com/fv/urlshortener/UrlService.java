package com.fv.urlshortener;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public Url shorten(UrlDTO dto) {
        final Url url = Url.builder()
                .originalUrl(dto.getLongUrl())
                .expirationDate(dto.getExpirationDate())
                .build();

        final Url saved = urlRepository.save(url);

        final String shortUrl = UrlConverterUtil.convertToShortUrl(saved.getId());
        saved.setShortUrl(shortUrl);

        return urlRepository.save(saved);
    }

    public String getOriginalUrl(String shortUrl) {
        final Optional<Url> optional = urlRepository.findByShortUrl(shortUrl);

        final Url url = optional.orElseThrow(() -> new UrlShortenerException("This short url was not found"));

        if (url.getExpirationDate() != null && !url.getExpirationDate().isAfter(LocalDate.now())) {
            throw new UrlShortenerException("This link is expired");
        }

        return url.getOriginalUrl();
    }

}
