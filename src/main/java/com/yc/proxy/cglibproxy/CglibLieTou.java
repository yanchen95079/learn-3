package com.yc.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yanchen
 * @ClassName JdkLieTou
 * @Date 2019/3/12 10:39
 */
public class CglibLieTou implements MethodInterceptor {
    public  Object getInstance(Class<?> clazz){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object invoke = methodProxy.invokeSuper(o,objects);
        after();
        return invoke;
    }


    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }


}
