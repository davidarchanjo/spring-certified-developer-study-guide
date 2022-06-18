package io.davidarchanjo.actuator.health.indicator;

import java.net.Socket;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("githubService")
public class GitHubServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        try (Socket socket = new Socket(new URL("https://api.github.com").getHost(), 80)) {
            return Health.up().build();
        } catch (Exception ex) {
            return Health.down()
                .withDetail("error", ex.getMessage())
                .build();
        }
    }
}