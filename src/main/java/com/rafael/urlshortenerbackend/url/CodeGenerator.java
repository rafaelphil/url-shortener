package com.rafael.urlshortenerbackend.url;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeGenerator {

    private final String Base62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final Random rnd = new Random();

    public String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append(Base62.charAt(rnd.nextInt( Base62.length())));
        }
        return code.toString();
    }
}
