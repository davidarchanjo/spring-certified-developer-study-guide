package io.davidarchanjo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DownstreamServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return new Health.Builder().up().build();
    }
}