package io.davidarchanjo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan(basePackages = { "io.davidarchanjo" })
public class SpringExpressionLanguageApplication {

    @Bean
    public Driver mercedesDriver(@Qualifier("mercedes") Drivable drivable) {
        return new Driver(drivable);
    }

    @Bean
    public Driver bmwDriver(@Qualifier("bmw") Drivable drivable) {
        return new Driver(drivable);
    }

    public static void main(String[] args) {        
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringExpressionLanguageApplication.class)) {
            log.info("{}", List.of(ctx.getBeanNamesForType(Driver.class)));
            log.info("{}", ctx.getBean("bmwDriver", Driver.class));
            log.info("{}", ctx.getBean("mercedesDriver", Driver.class));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}