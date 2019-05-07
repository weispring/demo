package com.liyulin.skills.proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Parent {


    public void method1(String a){
        log.info("print 测试 {}",a);
        method2(a);
    }

    public void method2(String a){
        log.info("sys 测试 {}",a);
    }

}
