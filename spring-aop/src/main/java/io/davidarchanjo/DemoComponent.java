package io.davidarchanjo;

import org.springframework.stereotype.Component;

@Component
public class DemoComponent {

    public void doSomething() {
    }

    @LogAccess
    public String doReturnValue(String value) {
        return "Hello World, " + value;
    }

    public String doThrowException(String value) {
        throw new RuntimeException("I'm an exception!");
    }
}
