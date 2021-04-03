package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbCheckInfoDetail;
import com.yc.demo.service.TbCheckInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbCheckInfoController
 * @Date 2021/3/5 15:27
 * @Description：
 */
@RestController
@Api(tags = "各种检测表数据控制层")
@RequestMapping(value = "/checkInfo")
public class TbCheckInfoController {
    @Autowired
    private TbCheckInfoService tbCheckInfoService;


    @ApiOperation("添加检查单信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(

            @RequestBody TbCheckInfo tbCheckInfo
    ) throws Exception {
        tbCheckInfoService.insert(tbCheckInfo);
        return HSResult.ok();
    }


    @ApiOperation("根据订单号等信息查看检测单详细信息")
    @RequestMapping(value = "/selectInfoALL", method = RequestMethod.POST)
    public HSResult selectInfoALL(

            @RequestBody TbCheckInfo tbCheckInfo
    ) throws Exception {
        return new HSResult(tbCheckInfoService.selectInfoALL(tbCheckInfo));
    }

    @ApiOperation("批量更改检测单详情(操作人,检测数值,操作结果)")
    @RequestMapping(value = "/batchUpdateDetail", method = RequestMethod.POST)
    public HSResult batchUpdateDetail(
            @RequestBody List<TbCheckInfoDetail> list
    ) throws Exception {
        tbCheckInfoService.batchUpdateDetail(list);
        return HSResult.ok();
    }

    @ApiOperation("复制")
    @RequestMapping(value = "/copyCheck", method = RequestMethod.POST)
    public HSResult copyCheck(
            @ApiParam("复制源")@RequestParam String sourceConfigKey, @ApiParam("复制到")@RequestParam String configKey
    ) throws Exception {
        tbCheckInfoService.copyCheck(sourceConfigKey,configKey);
        return HSResult.ok();
    }



}
