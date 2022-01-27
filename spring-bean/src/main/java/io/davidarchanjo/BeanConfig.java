package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class TheBean {
    private String name;

    public TheBean(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

@Configuration
public class BeanConfig {

    @Bean
    public TheBean bean1() {
        return new TheBean("bean1");
    }

    @Bean
    public TheBean bean2() {
        return new TheBean("bean2");
    }
}
