package com.admin.base.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PageAspect {
    @Pointcut("@annotation(com.admin.base.annotation.Page)")
    public void pageAspect() {
        
    }
    
    @Before("pageAspect()")    
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        
    }
    
    @After("pageAspect()")    
    public void doAfter(JoinPoint joinPoint) {
        
    }
}
