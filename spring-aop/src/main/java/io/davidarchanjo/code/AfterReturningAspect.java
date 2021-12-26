package io.davidarchanjo.code;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterReturningAspect {

    @AfterReturning("execution(* io.davidarchanjo.code.SampleComponent.do*(..))")
    public void advice(JoinPoint proceedingJoinPoint) {
        log.info("@AfterReturning Advice - {} {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
    }

}
