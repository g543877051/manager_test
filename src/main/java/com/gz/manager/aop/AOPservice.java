package com.gz.manager.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：北京活力天汇<br>
 * 作者：龚钊<br>
 * 版本：1.0<br>
 * 创建日期：2019年03月07日<br>
 */
@Component
@Aspect
public class AOPservice {
  /*  @Pointcut("execution(public * com.gz.manager.controller..*Controller..*(..))")
    public void commonService(){

    }

    @Around("commonService()")
    public void invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

        System.out.println("action = " + proceedingJoinPoint.getTarget().getClass().getSimpleName());
        System.out.println("url = " + request.getRequestURI());
        System.out.println("method = " + request.getMethod());
        System.out.println("Authorization = " + request.getHeader("Authorization"));
        System.out.println("param Map = " + request.getParameterMap());
        System.out.println(request.getParameter("title"));

        proceedingJoinPoint.proceed();
    }
*/
}
