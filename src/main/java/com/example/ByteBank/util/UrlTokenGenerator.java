package com.example.ByteBank.util;

import java.security.SecureRandom;
import java.util.Base64;

public class UrlTokenGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder().withoutPadding();

    /**
     * Generates a cryptographically secure, URL-safe random token.
     *
     * @return A short, random string safe for use in URLs.
     */
    public static String generateToken() {
        byte[] randomBytes = new byte[9]; // 72 bits ~12 base64 characters
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
