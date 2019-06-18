package com.liyulin.skills.log;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lixianchun
 * @Description
 * @date 2019/6/17 9:37
 */
@Slf4j
public class LogPrint {

    /**
     * https://blog.csdn.net/qq_28929589/article/details/82495193
     * @param args
     */
    public static void main(String[] args) {
        try {
            Long l = 0L;
            long a = l / 0;
        } catch (Exception e) {
            log.error("err:{}",e.getMessage(), e);
           /* log.error(e.getMessage(), e);
            log.info("异常1:{}", e.getMessage(), e);
            log.info("异常2{}", e.getMessage());*/
        }
    }
}
