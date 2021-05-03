package com.yc.demo.commom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;

/**
 * @author Yanchen
 * date 2021/5/3 16:12
 */
@Getter
@AllArgsConstructor
public enum DefaultEnum {
    DEFAULT_ENUM_0(0,"不合格"),
    DEFAULT_ENUM_1(1,"合格"),
    ;
    /**
     *
     */
    private  Integer code;
    /**
     *
     */
    private  String name;
    public static String getDefaultName(String code){
        if(StringUtils.isEmpty(code)){
            return null;
        }
        for (DefaultEnum defaultEnum : DefaultEnum.values()) {
            if(String.valueOf(defaultEnum.getCode()).equals(code)){
                return defaultEnum.getName();
            }
        }
        return null;
    }
}
