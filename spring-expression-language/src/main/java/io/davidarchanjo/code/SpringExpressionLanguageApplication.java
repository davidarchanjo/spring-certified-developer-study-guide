package io.davidarchanjo.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "io.davidarchanjo.code" })
public class SpringExpressionLanguageApplication {    

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringExpressionLanguageApplication.class);
        System.out.println(List.of(ctx.getBeanNamesForType(Driver.class)));
        Driver mercedesBean = ctx.getBean("mercedesDriver", Driver.class);
        Driver bmwBean = ctx.getBean("bmwDriver", Driver.class);
    }

    @Bean
    public Driver mercedesDriver(@Qualifier("mercedes") Drivable drivable) {
        return new Driver(drivable);
    }

    @Bean
    public Driver bmwDriver(@Qualifier("bmw") Drivable drivable) {
        return new Driver(drivable);
    }
    
}