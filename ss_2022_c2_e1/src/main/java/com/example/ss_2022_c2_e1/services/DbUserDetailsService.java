package com.example.ss_2022_c2_e1.services;

import com.example.ss_2022_c2_e1.repository.UserRepository;
import com.example.ss_2022_c2_e1.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findUserByUserName(username);
        return u.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("User name not fount"));
    }
}
