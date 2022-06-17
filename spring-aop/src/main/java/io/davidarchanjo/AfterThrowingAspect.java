package io.davidarchanjo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AfterThrowingAspect {

    @AfterThrowing("execution(* io.davidarchanjo.DemoComponent.do*(..))")
    public void logAfterExection(JoinPoint joinPoint) {
        log.info("@AfterThrowing Advice - {} {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

}
