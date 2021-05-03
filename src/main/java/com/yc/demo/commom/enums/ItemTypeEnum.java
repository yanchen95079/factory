package com.yc.demo.commom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yanchen
 * date 2021/5/3 15:21
 */
@Getter
@AllArgsConstructor
public enum  ItemTypeEnum {
    ITEM_TYPE_ENUM_0(1,"默认"),
    ITEM_TYPE_ENUM_1(1,"数值题"),
    ITEM_TYPE_ENUM_2(2,"自定义"),
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
