package io.davidarchanjo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBeanLifecycleCallbackOrderApplication {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public TheBean theBean() {
        return new TheBean("theBean");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanLifecycleCallbackOrderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            var bean = ctx.getBean(TheBean.class);
            log.info("{}", bean);
        };
    }
}