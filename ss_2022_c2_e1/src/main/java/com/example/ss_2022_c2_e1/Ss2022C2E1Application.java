package com.example.ss_2022_c2_e1;

import com.example.ss_2022_c2_e1.entity.User;
import com.example.ss_2022_c2_e1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ss2022C2E1Application {
//    @Autowired
//    UserRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Ss2022C2E1Application.class, args);
    }

//    @Bean
//    public void inserUser() {
//        repo.save(User.builder().userName("belal").password("123456").build());
//    }
}
