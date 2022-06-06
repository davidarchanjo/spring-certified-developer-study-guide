package io.davidarchanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBeanCallbackOrderApplication {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public TheBean theBean() {
        return new TheBean();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanCallbackOrderApplication.class, args);
    }
}