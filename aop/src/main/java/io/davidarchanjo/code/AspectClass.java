package io.davidarchanjo.code;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
    @Before("execution(public void newAccount())")
    public void BeforeNewAccount() {
        System.out.println(" @Before Advice - Executing the @Before advice ");
    }
}