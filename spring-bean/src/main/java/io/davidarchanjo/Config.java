package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Bar bar1() {
        return new Bar();
    }

    @Bean
    public Bar bar2() {
        return new Bar();
    }

    @Bean
    public Foo foo1() {
        return new Foo(bar1());
    }

    @Bean
    public Foo foo2() {
        return new Foo(bar1());
    }

}