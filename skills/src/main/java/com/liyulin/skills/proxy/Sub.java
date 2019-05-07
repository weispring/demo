package com.liyulin.skills.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sub extends Parent{
    @Override
    public void method1(String a) {
        //执行父类的么她后的,解析类的内部调用方法（包含@Transactional
        //@Async）无效
        super.method1(a);
        log.info("---");
    }

    @Override
    public void method2(String a) {
        super.method2(a);
    }

    public static void main(String[] args) {
        new Sub().method1("3333333");
    }
}
