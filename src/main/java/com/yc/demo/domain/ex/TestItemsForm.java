package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbTestItems;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName TestItemsEx
 * @Date 2021/2/25 17:14
 * @Description：
 */
@Setter
@Getter
public class TestItemsForm extends TbTestItems {
    /**
     * 装配名称（返回）
     */
    String assemblyContentName;
    /**
     * 此题目的枚举（返回）
     */
    List<Map> enumList;

    List<Long> assemblyContentIds;

    List<ItemEnumPoJo> itemEnumPoJoList;
}
