package com.sun.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author shawn
 * @descript
 * @create 2020-11-17 9:42 下午
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.sun.spring.annotation.aop.MyComputer.test(..))")
    public void pointCut(){ };


    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println("log start..."+"\t method:"+joinPoint.getSignature().getName()+",args:"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("log end...");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("log return..."+"\t result:"+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void logError(Exception ex){
        System.out.println("log error..."+"\t ex:"+ex);
    }
}
