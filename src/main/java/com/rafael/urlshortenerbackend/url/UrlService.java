package com.rafael.urlshortenerbackend.url;

import com.rafael.urlshortenerbackend.url.records.CreateUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlService {
    @Value("${base-url}")
    private String baseUrl;
    private final UrlRepository urlRepository;
    private final CodeGenerator codeGenerator;

    public Url findByCode(String code) {
        return urlRepository.findByCode(code).orElse(null);
    }

    public String createUrl(CreateUrlRequest createUrlRequest) {
        String code = codeGenerator.generateCode(7);

        Url url = new Url();
        url.setCode(code);
        url.setOriginalUrl(createUrlRequest.url());
        url.setCreatedAt(LocalDateTime.now());
        urlRepository.save(url);

        return baseUrl+"/"+code;
    }
}
