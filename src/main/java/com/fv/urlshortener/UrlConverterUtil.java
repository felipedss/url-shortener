package com.fv.urlshortener;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class UrlConverterUtil {

    private final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final char[] allowedCharacters = allowedString.toCharArray();

    public String convertToShortUrl(Integer number) {
        final StringBuilder shortUrl = new StringBuilder();
        while (number > 0) {
            shortUrl.append(allowedCharacters[number % 62]);
            number = number / 62;
        }
        return shortUrl.toString();
    }


}
