package com.springbootmybatis.aop;

import com.springbootmybatis.annotation.DataSource;
import com.springbootmybatis.annotation.Log;
import com.springbootmybatis.multiple.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by xkx on 2020/4/24.
 */

@Component
@Slf4j
@Aspect
@Order(-1)
public class LogAspect {

    @Pointcut("@within(com.springbootmybatis.annotation.Log) || @annotation(com.springbootmybatis.annotation.Log)")
    public void pointCut(){ }

    @Before("pointCut() && @annotation(log)")
    public void doBefore(Log log){
        System.out.println("前置通知---输入日志：" + log.value());
    }

    @After("pointCut() && @annotation(log)")
    public void doAfter(Log log){
        System.out.println("后置通知---输入日志：" + log.value());
    }

    @AfterReturning("pointCut()")
    public void logAsppect(JoinPoint jp) throws Throwable {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                //JoinPoint 对象可以获取目标业务方法的详细信息:方法签名,调用参数
                Signature m = jp.getSignature();
                //方法名
                String methodName = m.getName();
                MethodSignature signature = (MethodSignature) jp.getSignature();
                Method method = signature.getMethod();
                Log log = method.getAnnotation(Log.class);
                System.out.println("请求方法：" + methodName + "，Log Value(日志备注):" + log.value());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
