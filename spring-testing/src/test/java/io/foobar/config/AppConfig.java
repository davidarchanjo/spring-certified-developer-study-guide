package io.foobar.config;

import io.davidarchanjo.model.TheBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public TheBean theBean() {
        return new TheBean("bar");
    }
}
