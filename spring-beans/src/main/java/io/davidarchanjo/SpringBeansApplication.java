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
public class SpringBeansApplication {

    @Bean
    public ToDo fooToDo(@Qualifier("foo") ToDoable todoable) {
        return new ToDo(todoable);
    }

    @Bean
    public ToDo barToDo(@Qualifier("bar") ToDoable todoable) {
        return new ToDo(todoable);
    }

    public static void main(String[] args) {        
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeansApplication.class)) {
            log.info("{}", List.of(ctx.getBeanNamesForType(ToDo.class)));
            log.info("{}", ctx.getBean("fooToDo", ToDo.class));
            log.info("{}", ctx.getBean("barToDo", ToDo.class));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}