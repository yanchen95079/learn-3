package com.yc.proxy.jdkproxy;

import com.yc.proxy.Person;

/**
 * @author Yanchen
 * @ClassName Boy
 * @Date 2019/3/12 10:26
 */
public class Boy implements Person {
    @Override
    public void work() {
        System.out.println("boy work");
    }
}
