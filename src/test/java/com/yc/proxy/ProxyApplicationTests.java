package com.yc.proxy;

import com.yc.proxy.cglibproxy.CglibLieTou;
import com.yc.proxy.cglibproxy.Girl;
import com.yc.proxy.jdkproxy.Boy;
import com.yc.proxy.jdkproxy.JdkLieTou;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyApplicationTests {

    @Test
    public void JdkLieTou() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object instance = new JdkLieTou().getInstance(new Boy());
        Method work = instance.getClass().getMethod("work", null);
        work.invoke(instance);
    }
    @Test
    public void CglibLieTou() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Girl instance = (Girl)new CglibLieTou().getInstance(Girl.class);
        instance.work();
//        Object instance = new CglibLieTou().getInstance(Girl.class);
//        Method work = instance.getClass().getMethod("work", null);
//        work.invoke(instance);
    }
}
