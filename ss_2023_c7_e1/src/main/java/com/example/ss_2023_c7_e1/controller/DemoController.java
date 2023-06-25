package com.example.ss_2023_c7_e1.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    //PreAuthorize
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('read')")
    public String hello() {
//        var u = SecurityContextHolder.getContext().getAuthentication();
//        u.getAuthorities().forEach(System.err::println);
        return "Hello";
    }

    @PreAuthorize("hasAnyAuthority('read','write')")
    @GetMapping("/hello2")
    public String hello2() {
//        var u = SecurityContextHolder.getContext().getAuthentication();
//        u.getAuthorities().forEach(System.err::println);
        return "Hello2";
    }

    @PostMapping("/hello3/{smth}")
    @PreAuthorize("#path == authentication.name") // authentication.name == authentication.prinicipal.userName
    public String hello3(@PathVariable("smth") String path) {
        var u = SecurityContextHolder.getContext().getAuthentication();
        u.getAuthorities().forEach(System.err::println);
        return "hello3";
    }

    @PostMapping("/hello4/{smth}")
    @PreAuthorize("@demoConditionEvaluator.condition(#path)")
    public String hello4(@PathVariable("smth") String path) {

        return "hello4";
    }
//postAuthorize
    @PostMapping("/hello5")
    @PostAuthorize("returnObject != 'hello5'")
    public String hello5() {
        System.err.println("Enter ");
        return "hello5";
    }

    //preFilter
    @PostMapping("/hello6")
    @PreFilter("filterObject.contains('a')")
    public String hello6(@RequestBody List<String> list) {
        System.err.println("list :"+list);
        return "hello6";
    }
//postFilter
@PostMapping("/hello7")
@PostFilter("filterObject.contains('a')")
public List<String> hello7() {
    List<String> list = new ArrayList<>();
    list.add("abcd");
    list.add("wert");
    list.add("qaaz");
    list.add("wrty");

    // List.of(...) // List.of creates and immutable collection
    return list;
}


}
