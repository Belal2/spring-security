package com.example.ss_2022_c2_e1;

import com.example.ss_2022_c2_e1.entity.Authority;
import com.example.ss_2022_c2_e1.entity.User;
import com.example.ss_2022_c2_e1.entity.UserAuthorities;
import com.example.ss_2022_c2_e1.repository.AuthorityRepository;
import com.example.ss_2022_c2_e1.repository.UserAuthoritiesRepository;
import com.example.ss_2022_c2_e1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Ss2022C2E1Application {
    @Autowired
    UserRepository repo;
    @Autowired
    UserAuthoritiesRepository userAuthoritiesRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ss2022C2E1Application.class, args);
    }

//    @Bean
//    public void inserUser() {
//        var user = User.builder().userName("belal").password("123456").build();
//
//        var authority = Authority.builder().name("read").build();
//        authority = authorityRepository.save(authority);
//        user.setAuthorities(Set.of(authority));
//        user = repo.save(user);
//        var userAuthority = UserAuthorities.builder().authorityId(authority.getId()).userId(user.getId()).build();
//        userAuthoritiesRepository.save(userAuthority);
//
//    }
}
