package io.davidarchanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBeanLifecycleCallbackOrderApplication {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public TheBean demoBean() {
        return new TheBean();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanLifecycleCallbackOrderApplication.class, args);
    }
}