package com.example.ss_2023_c4_e1.config.security.filters;

import com.example.ss_2023_c4_e1.config.security.authentication.ApiKeyAuth;
import com.example.ss_2023_c4_e1.config.security.manager.ApiKeyAuthManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        ApiKeyAuthManager apiKeyAuthManager = new ApiKeyAuthManager(key);

        String incomeKey = request.getHeader("x-api-key");
        if (incomeKey == null || "null".equals(incomeKey)) {
            filterChain.doFilter(request, response);
        }

        Authentication auth = new ApiKeyAuth(incomeKey);

        auth = apiKeyAuthManager.authenticate(auth);
        if (auth.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }


}
