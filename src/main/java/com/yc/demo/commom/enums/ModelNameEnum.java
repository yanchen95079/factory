package com.yc.demo.commom.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yanchen
 * @ClassName ModelNameEnum
 * @Date 2021/2/19 12:25
 * @Description：
 */
@Getter
@AllArgsConstructor
public enum ModelNameEnum {
    /**
     * 初始化
     */
    FIRST_MODEL("QF05-221-Blue-CE-Model", "第一种模板类型"),

    ;
    /**
     * modelName
     */
    private final String modelName;
    /**
     * 名称
     */
    private final String name;
}
