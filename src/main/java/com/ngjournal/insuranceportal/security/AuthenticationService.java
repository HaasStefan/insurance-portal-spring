package com.ngjournal.insuranceportal.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    @Value("${security.auth_token_header_name}")
    private String authTokenHeaderName;

    @Value("${security.auth_token}")
    private String authToken;

    public Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(authTokenHeaderName);
        if (apiKey == null || !apiKey.equals(authToken)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}

