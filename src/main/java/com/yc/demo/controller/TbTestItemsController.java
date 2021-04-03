package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbTestItems;
import com.yc.demo.domain.ex.TestItemsForm;
import com.yc.demo.service.TbTestItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yanchen
 * @ClassName TbAssemblyContentController
 * @Date 2021/3/5 15:44
 * @Description：
 */
@RestController
@Api(tags = "检测项目表控制层")
@RequestMapping(value = "/testItems")
public class TbTestItemsController {
    @Autowired
    private TbTestItemsService tbTestItemsService;

    @ApiOperation("添加检测项目信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(

            @RequestBody TestItemsForm testItemsForm
    ) throws Exception {
        return new HSResult(tbTestItemsService.insert(testItemsForm));
    }

    @ApiOperation("根据id更新检测项目信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult updateById(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TestItemsForm testItemsForm
    ) throws Exception {
        testItemsForm.setId(id);
        return new HSResult(tbTestItemsService.updateById(testItemsForm));
    }

    @ApiOperation("查看检测项目信息")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(

            @RequestBody TestItemsForm tbTestItems
    ) throws Exception {
        return new HSResult(tbTestItemsService.selectAll(tbTestItems));
    }

    @ApiOperation("根据id删除检测项目信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public HSResult deleteById(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id
    ) throws Exception {
        tbTestItemsService.deleteById(id);
        return HSResult.ok();
    }
}
