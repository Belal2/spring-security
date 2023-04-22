package com.example.ss_2022_c2_e1.repository;

import com.example.ss_2022_c2_e1.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUserName(String userName);
}
