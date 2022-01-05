package io.davidarchanjo;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.SneakyThrows;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    @SneakyThrows
    public void configure(HttpSecurity http) {
        http.authorizeRequests()
            .antMatchers("/**").permitAll()
            ;
    }
}