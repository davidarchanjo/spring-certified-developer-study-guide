package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBeanFactoryPostProcessorApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBeanFactoryPostProcessorApplication.class, args);
        Triangle triangle = (Triangle) ctx.getBean("triangle");
        triangle.draw();
    }
}