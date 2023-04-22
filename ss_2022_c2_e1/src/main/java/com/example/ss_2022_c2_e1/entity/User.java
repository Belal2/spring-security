package com.example.ss_2022_c2_e1.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Document
@Builder
@Data
public class User {
    @MongoId
    private ObjectId Id;
    private String userName;
    private String password;
    private Set<Authority> authorities;
}
