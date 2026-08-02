package com.rafael.urlshortenerbackend.url;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
}
