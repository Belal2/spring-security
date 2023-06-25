package com.example.ss_2023_c3_e1.config.security.provider;

import com.example.ss_2023_c3_e1.config.security.authentication.CustomAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${our.secret.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication auth = (CustomAuthentication) authentication;

        if (key.equalsIgnoreCase(auth.getKey())) {
            return new CustomAuthentication(key, true);
        }
        throw new BadCredentialsException("Oh No provider Exception!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
