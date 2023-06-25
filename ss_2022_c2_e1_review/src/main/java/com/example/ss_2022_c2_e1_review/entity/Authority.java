package com.example.ss_2022_c2_e1_review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Builder
@Setter
@Getter
public class Authority {
    @MongoId
    private ObjectId id;

    private String name;

}
