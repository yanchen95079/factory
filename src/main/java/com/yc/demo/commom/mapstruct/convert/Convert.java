package com.yc.demo.commom.mapstruct.convert;



import com.yc.demo.domain.TbAssemblyContent;
import com.yc.demo.domain.TbTestItems;
import com.yc.demo.domain.ex.AssemblyContentEx;
import com.yc.demo.domain.ex.TestItemsEx;
import com.yc.demo.domain.ex.TestItemsForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName AConvert
 * @Date 2019/8/12 15:50
 * @Description：Convert
 */
@Mapper(componentModel = "spring")
public interface Convert {


    @Mappings({})
    AssemblyContentEx tbAssemblyContentToEx(TbAssemblyContent vo);

    List<AssemblyContentEx> tbAssemblyContentToEx(List<TbAssemblyContent> list);

    @Mappings({})
    TestItemsEx tbTestItemsToEx(TbTestItems vo);

    List<TestItemsEx> tbTestItemsToEx( List<TbTestItems> list);


    @Mappings({})
    TestItemsEx tbTestItemsFormToEx(TestItemsForm vo);

    List<TestItemsEx> tbTestItemsFormToEx( List<TestItemsForm> list);


    @Mappings({})
    TestItemsForm tbTestItemsToForm(TbTestItems vo);

    List<TestItemsForm> tbTestItemsToForm(List<TbTestItems> list);

}
