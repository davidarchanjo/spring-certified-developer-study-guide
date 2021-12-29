package io.davidarchanjo.code;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AroundAspect {

    @Pointcut("@annotation(io.davidarchanjo.code.LogAccess)")
    public void methodsAnnotatedWithLogAccess() {}

    @Around(value = "methodsAnnotatedWithLogAccess() && args(name)", argNames = "name")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        Object value = null;

        try {
            log.info("@Around Advice - args: {}", name /* or proceedingJoinPoint.getArgs() */);
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            log.info("@Around Advice after proceeding and before return - output: {}", value);
            value += "@ Around Advice";
        }

        return value;
    }
}
