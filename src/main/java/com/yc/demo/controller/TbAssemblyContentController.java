package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbAssemblyContent;
import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.ex.AssemblyContentForm;
import com.yc.demo.service.TbAssemblyContentService;
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
@Api(tags = "装配内容表控制层")
@RequestMapping(value = "/assemblyContent")
public class TbAssemblyContentController {
    @Autowired
    private TbAssemblyContentService tbAssemblyContentService;

    @ApiOperation("添加装配内容信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(

            @RequestBody TbAssemblyContent tbAssemblyContent
    ) throws Exception {
        return new HSResult(tbAssemblyContentService.insert(tbAssemblyContent));
    }

    @ApiOperation("根据id更新装配内容信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult updateById(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TbAssemblyContent tbAssemblyContent
    ) throws Exception {
        tbAssemblyContent.setId(id);
        return new HSResult(tbAssemblyContentService.updateById(tbAssemblyContent));
    }

    @ApiOperation("查看装配内容信息")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(

            @RequestBody AssemblyContentForm tbAssemblyContent
    ) throws Exception {
        return new HSResult(tbAssemblyContentService.select(tbAssemblyContent));
    }


    @ApiOperation("根据id删除装配内容信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public HSResult deleteById(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id
    ) throws Exception {
        tbAssemblyContentService.deleteById(id);
        return HSResult.ok();
    }
}
