package io.davidarchanjo.actuator.health.contributor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import io.davidarchanjo.actuator.health.indicator.BookTableHealthIndicator;
import io.davidarchanjo.actuator.health.indicator.GitHubServiceHealthIndicator;

@Component("bookApi")
public class BookApiHealthContributor implements CompositeHealthContributor {

    private Map<String, HealthContributor> contributors = new LinkedHashMap<>();
    
    public BookApiHealthContributor(
        GitHubServiceHealthIndicator gitHubApiServiceHealthIndicator,
        BookTableHealthIndicator databaseHealthContributor
    ) {
        contributors.put("database", databaseHealthContributor);
        contributors.put("githubService", gitHubApiServiceHealthIndicator );
    }

    @Override
    public Iterator<NamedContributor<HealthContributor>> iterator() {
        return contributors.entrySet().stream()
            .map(entry -> NamedContributor.of(entry.getKey(), entry.getValue()))
            .iterator();
    }

    @Override
    public HealthContributor getContributor(String name) {
        return contributors.get(name);
    }

}