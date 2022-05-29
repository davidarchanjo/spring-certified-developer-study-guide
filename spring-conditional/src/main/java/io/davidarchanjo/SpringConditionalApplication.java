package io.davidarchanjo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringConditionalApplication {

    public static void main(String[] args) {
        /*ApplicationContext ctx = */SpringApplication.run(SpringConditionalApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx, Environment env) {
        return args -> {
            Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
            // System.out.println(ctx.containsBeanDefinition("conditionalOnExpression")
            //     ? ctx.getBean("conditionalOnExpression", Clazz.class) : "conditionalOnExpression bean not loaded");

            // System.out.println(ctx.containsBeanDefinition("conditionalOnJava")
            //     ? ctx.getBean("conditionalOnJava", Clazz.class) : "conditionalOnJava bean not loaded");
        };
    }

}
