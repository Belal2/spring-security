package com.example.ss_2023_c12_e1.model;

import com.example.ss_2023_c12_e1.entities.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class AuthoritesSecurity implements GrantedAuthority {

  private final Authority authority;

  @Override
  public String getAuthority() {
    return authority.getName();
  }
}
