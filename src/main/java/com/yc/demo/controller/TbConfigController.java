package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbMapRelation;
import com.yc.demo.domain.ex.ConfigForm;
import com.yc.demo.domain.ex.MapRelationPojo;
import com.yc.demo.domain.ex.MapRelationSelect;
import com.yc.demo.service.TbConfigService;
import com.yc.demo.service.TbMapRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName TbConfigController
 * @Date 2021/3/5 15:42
 * @Description：
 */
@RestController
@Api(tags = "config控制层")
@RequestMapping(value = "/config")
public class TbConfigController {
    @Autowired
    private TbConfigService tbConfigService;
    @Autowired
    private TbMapRelationService tbMapRelationService;
    @ApiOperation("查看config信息")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(
            @RequestBody TbConfig config
    ) throws Exception {
        return new HSResult(tbConfigService.select(config));
    }

    @ApiOperation("添加config信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(
            @RequestBody TbConfig config
    ) throws Exception {
        tbConfigService.insert(config);
        return HSResult.ok();
    }

    @ApiOperation("更新config信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult update(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TbConfig config
    ) throws Exception {
        config.setId(id);
        tbConfigService.update(config);
        return HSResult.ok();
    }

    @ApiOperation("根据订单有的查询config")
    @RequestMapping(value = "selectAllConfigKey", method = RequestMethod.POST)
    public HSResult selectAllConfigKey(
            @RequestBody ConfigForm configForm
    ) throws Exception {
        return new HSResult(tbConfigService.selectAllConfigKey(configForm));

    }

    @ApiOperation("insertMapRelation")
    @RequestMapping(value = "insertMapRelation", method = RequestMethod.POST)
    public HSResult insertMapRelation(
            @RequestBody MapRelationPojo mapRelationPojo
    ) throws Exception {
        tbMapRelationService.insert(mapRelationPojo);
        return HSResult.ok();
    }
    @ApiOperation("updateMapRelation")
    @RequestMapping(value = "updateMapRelation/{id}", method = RequestMethod.POST)
    public HSResult updateMapRelation(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody MapRelationPojo mapRelationPojo
    ) throws Exception {
        mapRelationPojo.setId(id);
        tbMapRelationService.updateById(mapRelationPojo);
        return HSResult.ok();
    }
    @ApiOperation("delMapRelation")
    @RequestMapping(value = "delMapRelation/{id}", method = RequestMethod.POST)
    public HSResult delMapRelation(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id
            ) throws Exception {
        tbMapRelationService.delById(id);
        return HSResult.ok();
    }
    @ApiOperation("selectMapRelation")
    @RequestMapping(value = "selectMapRelation", method = RequestMethod.POST)
    public HSResult selectMapRelation(
            @RequestBody MapRelationSelect mapRelationSelect
    ) throws Exception {
        return new HSResult(tbMapRelationService.getMapRelation(mapRelationSelect.getConfigType(),mapRelationSelect.getCondition(),null,null,Map.class));

    }
}
