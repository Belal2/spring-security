package com.example.ss_2023_c7_e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var usds = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("belal").password(passwordEncoder().encode("123456")).authorities("read").build();
        var user2 = User.withUsername("Ahmed").password(passwordEncoder().encode("123456")).authorities("write").build();
        usds.createUser(user2);
        usds.createUser(user1);
        return usds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic().and().
                authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable().build();
    }
}
