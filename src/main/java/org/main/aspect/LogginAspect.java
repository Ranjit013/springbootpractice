package org.main.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogginAspect {
    @Around("@annotation(org.main.aspect.Loggable)")
    private Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        proceedingJoinPoint.getSourceLocation().getFileName();
        return "Hello World";
    }
}
