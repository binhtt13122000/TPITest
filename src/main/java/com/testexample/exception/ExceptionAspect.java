package com.testexample.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionAspect {

    @Around(value = "execution(* com.testexample.controller..*.*(..))")
    public Object handleExceptions(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;
        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (ConflictException conflictException) {
            log.error("ConflictException occurred: {}", conflictException.getReturnDesc());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Throwable throwable) {
            log.error("Throwable Error: {}", throwable.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return returnValue;
    }
}
