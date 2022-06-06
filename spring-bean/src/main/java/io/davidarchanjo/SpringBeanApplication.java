package io.davidarchanjo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBeanApplication { 

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanApplication.class, args);
    }

    // @Autowired tries to inject by looking up 
    @Autowired
    Bar bar;

    @Autowired
    @Qualifier("foo1")
    Foo foo;

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
            // Bar bar = ctx.getBean("bar", Bar.class);
            Foo foo = ctx.getBean("foo1", Foo.class);
            // Foo foo2 = ctx.getBean("foo2", Foo.class);
            // log.info("{}", List.of(ctx.getBeanNamesForType(ToDo.class)));
            // log.info("{}", ctx.getBean("bar", Bar.class));
            // log.info("{}", ctx.getBean("barToDo", ToDo.class));
            log.info("{}", foo.getBar().equals(bar));
            // log.info("{}", foo2.getBar().equals(bar));
        };
    }
}