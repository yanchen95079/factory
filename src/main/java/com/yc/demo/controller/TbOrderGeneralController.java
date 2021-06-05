package com.yc.demo.controller;

import com.github.pagehelper.PageInfo;
import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbOrderGeneral;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import com.yc.demo.domain.ex.TbAclEx;
import com.yc.demo.domain.ex.TbOrderGeneralSelectPage;
import com.yc.demo.service.TbOrderGeneralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/5 12:09
 */
@RestController
@Api(tags = "工作流控制层")
@RequestMapping(value = "/general")
public class TbOrderGeneralController {
    @Autowired
    private TbOrderGeneralService tbOrderGeneralService;


    @ApiOperation("下一步")
    @RequestMapping(value = "/nextStep", method = RequestMethod.POST)
    public HSResult nextStep(
            @RequestBody OrderGeneralPojo orderGeneralPojo
    ) throws Exception {
        tbOrderGeneralService.nextStep(orderGeneralPojo);
        return HSResult.ok();
    }

    @ApiOperation("上一步")
    @RequestMapping(value = "/backStep", method = RequestMethod.POST)
    public HSResult backStep(
            @RequestBody OrderGeneralPojo orderGeneralPojo
    ) throws Exception {
        tbOrderGeneralService.backStep(orderGeneralPojo);
        return HSResult.ok();
    }
    @ApiOperation("保存当前这步")
    @RequestMapping(value = "/saveStep", method = RequestMethod.POST)
    public HSResult saveStep(
            @RequestBody OrderGeneralPojo orderGeneralPojo
    ) throws Exception {
        tbOrderGeneralService.saveStep(orderGeneralPojo);
        return HSResult.ok();
    }

    @ApiOperation("受理")
    @RequestMapping(value = "/acceptance", method = RequestMethod.POST)
    public HSResult acceptance(
            @RequestBody OrderGeneralPojo orderGeneralPojo
    ) throws Exception {
        tbOrderGeneralService.acceptance(orderGeneralPojo);
        return HSResult.ok();
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/deleteByGroupUuid/{groupUuid}", method = RequestMethod.POST)
    public HSResult deleteByGroupUuid(
            @ApiParam(value = "groupUuid") @PathVariable(value = "groupUuid") String groupUuid
    ) throws Exception {
        tbOrderGeneralService.deleteByGroupUuid(groupUuid);
        return HSResult.ok();
    }


    @ApiOperation("分页查询")
    @RequestMapping(value = "/selectPage", method = RequestMethod.POST)
    public HSResult selectPage(
                    @RequestBody TbOrderGeneralSelectPage tbOrderGeneralSelectPage
    ) throws Exception {
        return new HSResult(tbOrderGeneralService.selectPage(tbOrderGeneralSelectPage));
    }
    @ApiOperation("查询详情")
    @RequestMapping(value = "/selectDetail/{groupUuid}", method = RequestMethod.POST)
    public HSResult selectDetailByGroupUuid(
            @ApiParam(value = "groupUuid") @PathVariable(value = "groupUuid") String groupUuid
    ) throws Exception {
        return new HSResult(tbOrderGeneralService.selectDetailByGroupUuid(groupUuid));
    }

}
