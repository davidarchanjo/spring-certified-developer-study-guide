package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AfterThrowingAspect {

    @AfterThrowing("execution(* io.davidarchanjo.code.TodoComponent.do*(..))")
    public void logAfterExection(final JoinPoint proceedingJoinPoint) {
        log.info("@AfterThrowing Advice - {} {}", proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
    }

}
