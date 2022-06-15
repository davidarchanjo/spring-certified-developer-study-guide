package io.davidarchanjo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
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