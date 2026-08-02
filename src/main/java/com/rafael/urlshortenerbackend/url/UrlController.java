package com.rafael.urlshortenerbackend.url;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code) {
        Url url = urlService.findByCode(code);
        if (url == null) return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getOriginalUrl())).build();
    }
}
