package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public ProgrammingLanguage programmingLanguage() {
        return new ProgrammingLanguage();
    }
}