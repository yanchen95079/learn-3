package com.yc.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Yanchen
 * @ClassName JdkLieTou
 * @Date 2019/3/12 10:39
 */
public class JdkLieTou implements InvocationHandler {
    private Object object;
    public  Object getInstance(Object obj){
        this.object=obj;
        Class<?> clazz = object.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.object, args);
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
