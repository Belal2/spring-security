package com.example.ss_2022_c2_e1_review.security;

import com.example.ss_2022_c2_e1_review.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class AuthoritesSecurity implements GrantedAuthority {
    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
