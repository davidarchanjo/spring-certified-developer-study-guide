package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AfterReturningAspect {

    @AfterReturning("execution(* io.davidarchanjo.code.DemoComponent.do*(..))")
    public void advice(JoinPoint proceedingJoinPoint) {
        log.info("@AfterReturning Advice - {} {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
    }

}
