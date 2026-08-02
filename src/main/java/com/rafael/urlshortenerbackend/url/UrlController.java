package com.rafael.urlshortenerbackend.url;

import com.rafael.urlshortenerbackend.url.records.CreateUrlRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody CreateUrlRequest createUrlRequest) {
        String code = urlService.createUrl(createUrlRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(code);
    }
}
