package com.example.ss_2022_c2_e1_review.services;

import com.example.ss_2022_c2_e1_review.repository.UserRepository;
import com.example.ss_2022_c2_e1_review.security.UserSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbUserDetailsService implements UserDetailsService {
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findUserByUserName(username);
        return user.map(UserSecurity::new).orElseThrow(() -> new UsernameNotFoundException("User name not fount"));
    }
}
