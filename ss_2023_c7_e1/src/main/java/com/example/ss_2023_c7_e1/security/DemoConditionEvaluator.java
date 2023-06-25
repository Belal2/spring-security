package com.example.ss_2023_c7_e1.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DemoConditionEvaluator {
public boolean condition(String val){
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.err.println(val);
    return false;
}
}
