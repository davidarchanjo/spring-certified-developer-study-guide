package io.davidarchanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanFactoryPostProcessorApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBeanFactoryPostProcessorApplication.class, args);
        Triangle triangle = (Triangle) ctx.getBean("triangle");
        triangle.draw();
    }
}