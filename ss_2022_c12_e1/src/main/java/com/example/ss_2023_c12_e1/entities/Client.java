package com.example.ss_2023_c12_e1.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

  @MongoId
  private String Id;

  private String clientId;
  private String secret;
  private Set<String> redirectUri;
  private Set<String> scope;
  private Set<String> authMethod;
  private Set<String> grantType;

  public static Client from(RegisteredClient registeredClient) {
    Client client = new Client();

    client.setClientId(registeredClient.getClientId());
    client.setSecret(registeredClient.getClientSecret());
    Set<String> redirectsUri = new HashSet<>();
    registeredClient.getRedirectUris().forEach(e->redirectsUri.add(e));
    client.setRedirectUri(redirectsUri);
    Set<String> scopes  = new HashSet<>();
    registeredClient.getScopes().forEach(e->scopes.add(e));
    client.setScope(scopes);
    Set<String> cams = new HashSet<>();
    registeredClient.getClientAuthenticationMethods().forEach(e->cams.add(e.getValue()));
    client.setAuthMethod(cams);
    Set<String> agTs = new HashSet<>();
    registeredClient.getAuthorizationGrantTypes().forEach(e->agTs.add(e.getValue()));
    client.setGrantType(agTs);
    return client;
  }

  public static RegisteredClient from(Client client) {
    return RegisteredClient.withId(client.getId())
        .clientId(client.getClientId())
        .clientSecret(client.getSecret())
        .scope(client.getScope().stream().findAny().get())
        .redirectUri(client.getRedirectUri().stream().findAny().get())
        .clientAuthenticationMethod(new ClientAuthenticationMethod(client.getAuthMethod().stream().findAny().get()))
        .authorizationGrantType(new AuthorizationGrantType(client.getGrantType().stream().findAny().get()))
        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
        .tokenSettings(TokenSettings.builder()
//            .accessTokenFormat(OAuth2TokenFormat.REFERENCE) // opaque
            .accessTokenTimeToLive(Duration.ofHours(24)).build())
        .build();
  }
}
