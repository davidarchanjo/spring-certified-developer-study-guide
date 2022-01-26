package io.davidarchanjo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@Configuration
@ConfigurationProperties("bar")
public class BarProperties {
    private Map<String, String> datasource;

    public String getUrl() {
        return this.datasource.get("url");
    }

    public String getUsername() {
        return this.datasource.get("username");
    }

    public String getPassword() {
        return this.datasource.get("password");
    }

    public String getDriverClassName() {
        return this.datasource.get("driver-class-name");
    }
}
