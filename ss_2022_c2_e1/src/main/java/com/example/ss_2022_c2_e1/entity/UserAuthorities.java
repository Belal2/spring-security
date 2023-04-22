package com.example.ss_2022_c2_e1.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document("userAuthorities")
public class UserAuthorities {
    private String userId;
    private String authorityId;
}
