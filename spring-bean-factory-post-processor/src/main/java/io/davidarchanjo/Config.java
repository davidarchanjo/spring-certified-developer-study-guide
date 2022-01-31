package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Point pointA() {
        return new Point(0, 0);
    }

    @Bean
    public Point pointB() {
        return new Point(-20, 0);
    }

    @Bean
    public Point pointC() {
        return new Point(21, 1);
    }
}
