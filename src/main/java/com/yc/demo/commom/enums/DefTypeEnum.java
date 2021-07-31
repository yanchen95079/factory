package com.yc.demo.commom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yanchen
 * date 2021/5/3 15:21
 */
@Getter
@AllArgsConstructor
public enum DefTypeEnum {
    DEF_TYPE_ENUM_1(1,"补货单"),
    DEF_TYPE_ENUM_2(2,"换货单"),
    DEF_TYPE_ENUM_3(3,"入库单"),
    DEF_TYPE_ENUM_4(4,"库位转移单"),
    DEF_TYPE_ENUM_5(5,"短缺报告"),
    DEF_TYPE_ENUM_6(6,"NCM库位转移单"),
    ;
    /**
     *
     */
    private  Integer code;
    /**
     *
     */
    private  String name;

}
