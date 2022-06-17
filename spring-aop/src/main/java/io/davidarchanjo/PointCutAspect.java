package io.davidarchanjo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class PointCutAspect {

    @Pointcut("@annotation(io.davidarchanjo.LogAccess)")
    public void loggableMethods() {
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint joinPoint) {
        var methodName = joinPoint.getSignature().getName();
        log.info("Loggable method executed '{}'", methodName);
    }

}
