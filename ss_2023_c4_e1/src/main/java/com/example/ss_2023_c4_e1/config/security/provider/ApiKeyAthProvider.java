package com.example.ss_2023_c4_e1.config.security.provider;

import com.example.ss_2023_c4_e1.config.security.authentication.ApiKeyAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class ApiKeyAthProvider implements AuthenticationProvider {
    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuth auth = (ApiKeyAuth) authentication;
        if (key.equals(auth.getKey())) {
            auth.setAuthenticated(true);
            return auth;
        }
        throw new BadCredentialsException("not authenticated");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuth.class.equals(authentication);
    }
}
