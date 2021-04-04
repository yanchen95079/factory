package com.yc.demo.service;

import com.yc.demo.domain.TbMapRelation;
import com.yc.demo.domain.TbTestItems;
import com.yc.demo.domain.ex.TestItemsForm;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbTestItemsService
 * @Date 2021/2/25 12:04
 * @Description：
 */
public interface TbTestItemsService {
    List<TbTestItems> select(TbTestItems tbTestItems);

    List<TbTestItems> selectByAssemblyContentIds(List<Long> assemblyContentIds);

    List<TestItemsForm> selectAll(TestItemsForm tbTestItems);


    TestItemsForm insert(TestItemsForm tbTestItems);

    TestItemsForm insert(TbTestItems tbTestItems, List<TbMapRelation> tbMapRelationList);

    TestItemsForm updateById(TestItemsForm testItemsForm);

    void deleteById(Long id);
}
