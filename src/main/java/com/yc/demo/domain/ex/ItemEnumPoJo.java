package com.yc.demo.domain.ex;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/4/3 23:50
 */
@Setter
@Getter
public class ItemEnumPoJo {
    /**
     *题目枚举的key
     * */
    String enumKey;
    /**
     *题目枚举的value中文
     * */
    String enumValue;
    /**
     *题目枚举的单选的对错
     * */
    String enumFlag;
    /**
     * 题目枚举的位置
     */
    Integer position;
}
