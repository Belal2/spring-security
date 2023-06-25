package com.example.ss_2023_c3_e1_review.config.security.provider;

import com.example.ss_2023_c3_e1_review.config.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${my_secret_key}")
    private String myKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication custom = (CustomAuthentication) authentication;
        if (myKey.equals(custom.getKey()))
            return new CustomAuthentication(myKey, true);
        throw new BadCredentialsException("Key not valid !");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
