package com.example.ss_2022_c2_e1_review.repository;

import com.example.ss_2022_c2_e1_review.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findUserByUserName(String userName);
}
