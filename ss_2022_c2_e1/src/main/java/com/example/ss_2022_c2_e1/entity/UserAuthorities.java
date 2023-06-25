package com.example.ss_2022_c2_e1.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Document("userAuthorities")
@Setter
@Getter
public class UserAuthorities {
    @MongoId
    private ObjectId id;
    private ObjectId userId;
    private ObjectId authorityId;
}
