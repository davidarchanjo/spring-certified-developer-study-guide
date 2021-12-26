package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* io.davidarchanjo.code.SampleComponent.doSomething(..))")
    public void advice(JoinPoint proceedingJoinPoint) {
        log.info("@Before Advice - {} {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
    }

}
