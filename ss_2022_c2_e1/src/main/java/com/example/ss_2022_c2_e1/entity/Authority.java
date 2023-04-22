package com.example.ss_2022_c2_e1.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;

//@Document
@Builder
public class Authority  implements GrantedAuthority {
    @MongoId
    private String id;

    private String name;

    @Override
    public String getAuthority() {
        return null;
    }
}
