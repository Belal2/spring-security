package com.example.ss_2023_c3_e1.config.security.manager;

import com.example.ss_2023_c3_e1.config.security.authentication.CustomAuthentication;
import com.example.ss_2023_c3_e1.config.security.provider.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        if (customAuthenticationProvider.supports(authentication.getClass()))
            return customAuthenticationProvider.authenticate(authentication);
        throw new BadCredentialsException("Oh No!");
    }
}
