package ldifabio.recursosapi.service;

import ldifabio.recursosapi.UsuarioKeycloak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Repository
public class KeycloackService {
    @Value("${keycloak.auth-server-url}")
    String host;
    private final String path = "/admin/realms/mercantilandina/users";
    private final AuthorizedClientServiceOAuth2AuthorizedClientManager manager;


    public KeycloackService(AuthorizedClientServiceOAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    public void registrarUsuarioEnKeycloak(UsuarioKeycloak usuario) {
        log.debug("Guardo usuario en keycloak");
        try {
            OAuth2AccessToken accessToken = getAccessToken();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + accessToken.getTokenValue());

            HttpEntity<UsuarioKeycloak> requestEntity =
                    new HttpEntity<>(usuario, headers);
            log.info("Invocacion de keycloak:{}", host + path);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(
                    host + path,
                    requestEntity,
                    UsuarioKeycloak.class
            );
        } catch (Exception e) {
            log.info("Fallo la creacion del usuario en keycloak");
//            throw new NotFoundException("Fallo la creacion del usuario en keycloak");

        }

    }


    private OAuth2AccessToken getAccessToken() {
        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("keycloak").principal("kcclient").build();

        OAuth2AuthorizedClient authorizedClient = this.manager.authorize(authorizeRequest);
        return Objects.requireNonNull(authorizedClient).getAccessToken();

    }

}


