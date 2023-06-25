package com.example.ss_2023_c12_e1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ss2023C12E1Application {

//  @Autowired
//  ClientRepository clientrepo;

  public static void main(String[] args) {
    SpringApplication.run(Ss2023C12E1Application.class, args);
  }

  // http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=https://springone.io/authorized&code_challenge=QYPAZ5NU8yvtlQ9erXrUYR-T5AGCjCF47vN-KsaI2A8&code_challenge_method=S256
  // http://localhost:8080/oauth2/token?client_id=client&redirect_uri=https://springone.io/authorized&grant_type=authorization_code&code_verifier=qPsH306-ZDDaOE8DFzVn05TkN3ZZoVmI_6x4LsVglQI&code=7hY8GYpA68D4kPEkO4qLqAX7gcgj6FtHsQWtKlfM7NAtmSvZVNj6Efm_PuF51ctPAtepN83y3ItZixqjzBH59IWA4AeqQcTwAZ5xTdMkzInMJLvc4DG-lO2lNLEibzVT

//   @Bean
//  public void insert() {
//    Client c = Client
//      .builder()
//      .clientId("client")
//      .secret("secret")
//      .redirectUri(Set.of("https://springone.io/authorized"))
//      .scope(Set.of("openid"))
//      .authMethod(Set.of("client_secret_basic"))
//      .grantType(Set.of("authorization_code"))
//      .build();
//    clientrepo.save(c);
//  }
}
