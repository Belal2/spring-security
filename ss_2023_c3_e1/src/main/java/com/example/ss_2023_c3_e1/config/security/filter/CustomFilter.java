package com.example.ss_2023_c3_e1.config.security.filter;

import com.example.ss_2023_c3_e1.config.security.authentication.CustomAuthentication;
import com.example.ss_2023_c3_e1.config.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {
    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.err.println(request.getHeader("key"));

        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication ca = new CustomAuthentication(key, false);
        var a = customAuthenticationManager.authenticate(ca);
        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }
    }
}
