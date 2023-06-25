package com.example.ss_2023_c12_e1.services;

import com.example.ss_2023_c12_e1.model.SecurityUser;
import com.example.ss_2023_c12_e1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    var user = userRepo.findUserByUserName(username);
    return user
      .map(SecurityUser::new)
      .orElseThrow(() -> new UsernameNotFoundException("User name not fount"));
  }
}
