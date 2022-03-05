package io.davidarchanjo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class GitHubAPIHealthIndicator implements HealthIndicator {
    private final RestTemplate restTemplate;

    @Override
    public Health health() {
        try {
            ParameterizedTypeReference<Map<String, String>> reference = new ParameterizedTypeReference<>() {};
            ResponseEntity<Map<String, String>> result = restTemplate.exchange("https://api.github.com/", HttpMethod.GET, null, reference);
            return (result.getStatusCode().is2xxSuccessful() && Objects.nonNull(result.getBody()))
                ? Health.up().withDetails(result.getBody()).build()
                : Health.down().withDetail("status", result.getStatusCode()).build();
        } catch (RestClientException ex) {
            return Health.down().withException(ex).build();
        }
    }
}