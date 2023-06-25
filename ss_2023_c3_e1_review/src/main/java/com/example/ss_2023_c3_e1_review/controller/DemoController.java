package com.example.ss_2023_c3_e1_review.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/hello")
    public String hello() {
//        var u = SecurityContextHolder.getContext().getAuthentication();
//        u.getAuthorities().forEach(System.err::println);
        return "Hello";
    }
}
