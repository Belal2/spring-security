package com.example.ss_2022_c2_e1_review.repository;

import com.example.ss_2022_c2_e1_review.entity.Authority;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorityRepository  extends MongoRepository<Authority, ObjectId> {
}
