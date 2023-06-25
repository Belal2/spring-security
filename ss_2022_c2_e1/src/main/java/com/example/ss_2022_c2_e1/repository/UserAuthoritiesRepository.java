package com.example.ss_2022_c2_e1.repository;

import com.example.ss_2022_c2_e1.entity.UserAuthorities;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAuthoritiesRepository extends MongoRepository<UserAuthorities, ObjectId> {
}
