package com.admin.base.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.admin.base.annotation.Page;

@Aspect
@Component
public class PageAspect {

    @Around("@annotation(page)")
    public Object process(ProceedingJoinPoint jointPoint,Page page) throws Throwable {
        System.out.println("In AOP process");
        jointPoint.proceed();
        return 5; // jointPoint.proceed();
    }

}
