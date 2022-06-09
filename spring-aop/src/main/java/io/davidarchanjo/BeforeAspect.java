package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* io.davidarchanjo.DemoComponent.doSomething(..))")
    public void advice(JoinPoint joinPoint) {
        log.info("@Before Advice - {} {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

}
