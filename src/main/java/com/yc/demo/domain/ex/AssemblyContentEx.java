package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbAssemblyContent;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName AssemblyContentEx
 * @Date 2021/2/25 17:14
 * @Description：
 */
@Getter
@Setter
public class AssemblyContentEx extends TbAssemblyContent {
    /**
     * 检测项目
     */
    List<TestItemsEx> testItemsList;
    /**
     * 是否可以展示
     */
    Boolean editFlat=false;
}
