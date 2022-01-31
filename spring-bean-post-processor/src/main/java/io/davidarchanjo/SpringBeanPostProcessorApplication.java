package io.davidarchanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanPostProcessorApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBeanPostProcessorApplication.class, args);
        Triangle triangle = ctx.getBean("triangle", Triangle.class);
        triangle.draw();
    }
}