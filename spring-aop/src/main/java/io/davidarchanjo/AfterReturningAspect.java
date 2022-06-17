package io.davidarchanjo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterReturningAspect {

    @AfterReturning("execution(* io.davidarchanjo.DemoComponent.do*(..))")
    public void advice(JoinPoint joinPoint) {
        log.info("@AfterReturning Advice - {} {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

}
