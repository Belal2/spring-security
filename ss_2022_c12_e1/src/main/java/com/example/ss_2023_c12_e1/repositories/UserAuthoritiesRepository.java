package com.example.ss_2023_c12_e1.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ss_2023_c12_e1.entities.UserAuthorities;

public interface UserAuthoritiesRepository extends MongoRepository<UserAuthorities, ObjectId> {
}
