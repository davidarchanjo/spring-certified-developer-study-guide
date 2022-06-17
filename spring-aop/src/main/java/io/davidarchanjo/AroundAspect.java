package io.davidarchanjo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AroundAspect {

    @Pointcut("execution(* io.davidarchanjo.DemoComponent.do*(..))")
    public void matchingMethod() {
    }

    @Around(value = "matchingMethod() && args(name)", argNames = "name")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        Object value = null;

        try {
            log.info("@Around Advice - args: {}", name /* or proceedingJoinPoint.getArgs() */);
            value = proceedingJoinPoint.proceed();
        } finally {
            log.info("@Around Advice after proceeding and before return - output: {}", value);
            value += "@ Around Advice";
        }

        return value;
    }
}
