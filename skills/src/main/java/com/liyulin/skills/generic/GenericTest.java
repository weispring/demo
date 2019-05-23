package com.liyulin.skills.generic;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lixianchun
 * @Date: 2019/5/10 22:39
 * @Description:
 */
@Slf4j
public class GenericTest implements GenericInterface<String> {
    @Override
    public void setBoyd(String o) {
        log.info("setBody : {}",o);
    }

    /**
     * 桥接方法
     * 因为泛型是在1.5引入的，为了向前兼容，所以会在编译时去掉泛型（泛型擦除）。那么SuperClass接口中的method方法的参数在虚拟机中只能是Object。
     * @param o
     */
    /*public void setBoyd(Object o) {
        setBoyd((String) o);
    }*/


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GenericTest obj = new GenericTest();
        Method m = GenericTest.class.getMethod("setBoyd", String.class);
        m.invoke(obj, "XXXXXXXXXXXXXXXXXX");
        System.out.println(m.isBridge());
        m = GenericTest.class.getMethod("setBoyd", Object.class);
        m.invoke(obj, "##################");
        System.out.println(m.isBridge());
    }
}
