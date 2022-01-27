package io.davidarchanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(SpringAopApplication.class, args);
        DemoComponent component = ctx.getBean(DemoComponent.class);
        component.doSomething();
        String value = component.doReturnValue("David Archanjo");
        log.info("@Around Advice after return - changed output: {}", value);
        try { component.doThrowException(""); } catch (Exception e) {}
    }

}
