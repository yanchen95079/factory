package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbCheckInfoDetail;
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
public class TestItemsEx extends TbTestItems {
    /**
     * 每个项目的结果
     */
    TbCheckInfoDetailEx tbCheckInfoDetail;
    /**
     * 此题目的枚举
     */
    List<Map> enumList;
}
