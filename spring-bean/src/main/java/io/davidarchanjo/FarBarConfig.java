package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FarBarConfig {

    @Bean
    public Foo fuu1() {
        return new Bar("David");
    }

    @Bean
    public Foo fuu2() {
        return new Bar("Archanjo");
    }
}
