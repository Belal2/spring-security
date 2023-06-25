package com.example.ss_2023_c5_e1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/hello2")
    public String hello2() {
//        var u = SecurityContextHolder.getContext().getAuthentication();
//        u.getAuthorities().forEach(System.err::println);
        return "Hello2";
    }

    @PostMapping("/hello3")
    public String hello3() {
//        var u = SecurityContextHolder.getContext().getAuthentication();
//        u.getAuthorities().forEach(System.err::println);
        return "hello3";
    }
}
