package com.ronglexie.ronglexiegirl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP切面类
 *
 * @author ronglexie
 * @version 2018-1-15
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 日志对象
     */
    public static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.ronglexie.ronglexiegirl.web.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("==========Aspect Test Start==========");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        System.out.println("==========Aspect Test End==========");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterRuturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
