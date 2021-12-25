package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SpringAopApplication.class, args);
        TodoComponent component = application.getBean(TodoComponent.class);
        component.doSomething();
        String value = component.doReturnValue("David Archanjo");
        log.info("@Around Advice after return - changed output: {}", value);
        try { component.doThrowException(""); } catch (Exception e) {}
    }

}
