package com.rafael.urlshortenerbackend.url.records;

import jakarta.validation.constraints.NotBlank;

public record CreateUrlRequest(
        @NotBlank String url
) {
}
