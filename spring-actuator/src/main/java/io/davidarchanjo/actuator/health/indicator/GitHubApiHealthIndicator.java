package io.davidarchanjo.actuator.health.indicator;

import java.util.Map;
import java.util.Objects;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component("githubApi")
public class GitHubApiHealthIndicator implements HealthIndicator {

    private final RestTemplate restTemplate;

    @Override
    public Health health() {
        try {
            ResponseEntity<Map> result = restTemplate.getForEntity("https://api.github.com/", Map.class);

            return (result.getStatusCode().is2xxSuccessful() && Objects.nonNull(result.getBody()))
                ? Health.up().withDetails(result.getBody()).build()
                : Health.down().withDetail("status", result.getStatusCode()).build();
        } catch (RestClientException ex) {
            return Health.down().withException(ex).build();
        }
    }
}