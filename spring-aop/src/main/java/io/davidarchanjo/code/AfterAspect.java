package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AfterAspect {

    @After("execution(* io.davidarchanjo.code.TodoComponent.doSomething())")
    public void advice(final JoinPoint proceedingJoinPoint) {
        log.info("@After Advice - {} {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
    }

}
