package com.example.ss_2023_c4_e1.config.security.manager;

import com.example.ss_2023_c4_e1.config.security.authentication.ApiKeyAuth;
import com.example.ss_2023_c4_e1.config.security.provider.ApiKeyAthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class ApiKeyAuthManager implements AuthenticationManager {
    private final String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAthProvider apiKeyAthProvider = new ApiKeyAthProvider(key);
        if (apiKeyAthProvider.supports(authentication.getClass())) {
            return apiKeyAthProvider.authenticate(authentication);
        }
        throw new BadCredentialsException(" not auth");
    }
}
