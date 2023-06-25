package com.example.ss_2023_c3_e1_review.config.security.filter;

import com.example.ss_2023_c3_e1_review.config.security.authentication.CustomAuthentication;
import com.example.ss_2023_c3_e1_review.config.security.manager.CustomAuthenticationManager;
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
public class CustomAuthFilter extends OncePerRequestFilter {
    private final CustomAuthenticationManager manager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String headerKey = request.getHeader("key");
        CustomAuthentication au = new CustomAuthentication(headerKey, false);
        var a = manager.authenticate(au);
        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }

    }
}
