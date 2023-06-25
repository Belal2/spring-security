package com.example.ss_2023_c12_e1.repositories;


import com.example.ss_2023_c12_e1.entities.Client;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClientRepository extends MongoRepository<Client, String> {

  @Query("SELECT c FROM Client c WHERE c.clientId = :clientId")
  Optional<Client> findByClientId(String clientId);

}
