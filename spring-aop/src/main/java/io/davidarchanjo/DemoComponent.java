package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoComponent {

    public void doSomething() {
        log.info("Doing something important!");
    }

    @LogAccess
    public String doReturnValue(String value) {
        return "Hello World, " + value;
    }

    public String doThrowException(String value) {
        throw new RuntimeException("I'm an runtime exception!");
    }
}
