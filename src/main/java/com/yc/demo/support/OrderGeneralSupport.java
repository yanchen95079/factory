package com.yc.demo.support;

import org.springframework.stereotype.Component;

/**
 * @author Yanchen
 * date 2021/5/29 20:36
 */
@Component
public class OrderGeneralSupport {
    public void insetOrder(){
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表新增
    }

    public void updateOrder(){
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表update
    }
}
