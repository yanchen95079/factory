package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbCheckInfoDetail;
import com.yc.demo.domain.ex.CheckInfoSelectPage;
import com.yc.demo.service.TbCheckInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbCheckInfoController
 * @Date 2021/3/5 15:27
 * @Description：
 */
@Controller
@Api(tags = "各种检测表数据控制层")
@RequestMapping(value = "/checkInfo")
public class TbCheckInfoController {
    @Autowired
    private TbCheckInfoService tbCheckInfoService;

    @ResponseBody
    @ApiOperation("检查单分页查询")
    @RequestMapping(value = "/selectPage", method = RequestMethod.POST)
    public HSResult selectPage(

            @RequestBody CheckInfoSelectPage checkInfoSelectPage
    ) throws Exception {
        return new HSResult(tbCheckInfoService.checkInfoSelectPage(checkInfoSelectPage));
    }


    @ApiOperation("添加检查单信息")
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(

            @RequestBody TbCheckInfo tbCheckInfo
    ) throws Exception {
        tbCheckInfoService.insert(tbCheckInfo);
        return HSResult.ok();
    }


    @ApiOperation("根据订单号等信息查看检测单详细信息")
    @ResponseBody
    @RequestMapping(value = "/selectInfoALL/{samplingFlag}", method = RequestMethod.POST)
    public HSResult selectInfoALL(
            @ApiParam(value = "samplingFlag") @PathVariable(value = "samplingFlag") Integer samplingFlag,
            @RequestBody TbCheckInfo tbCheckInfo
    ) throws Exception {
        return new HSResult(tbCheckInfoService.selectInfoALL(tbCheckInfo,samplingFlag));
    }

    @ApiOperation("批量更改检测单详情(操作人,检测数值,操作结果)")
    @ResponseBody
    @RequestMapping(value = "/batchUpdateDetail/{infoState}", method = RequestMethod.POST)
    public HSResult batchUpdateDetail(
            @ApiParam(value = "infoState") @PathVariable(value = "infoState") int infoState,
            @RequestBody List<TbCheckInfoDetail> list
    ) throws Exception {
        tbCheckInfoService.batchUpdateDetail(list,infoState);
        return HSResult.ok();
    }

    @ApiOperation("复制")
    @ResponseBody
    @RequestMapping(value = "/copyCheck", method = RequestMethod.POST)
    public HSResult copyCheck(
            @ApiParam("复制源")@RequestParam String sourceConfigKey, @ApiParam("复制到")@RequestParam String configKey
    ) throws Exception {
        tbCheckInfoService.copyCheck(sourceConfigKey,configKey);
        return HSResult.ok();
    }

    @ApiOperation("导出Excel")
    @RequestMapping(value = "/outExcel/{samplingFlag}", method = RequestMethod.POST)
    public void outExcel(
            @ApiParam(value = "samplingFlag") @PathVariable(value = "samplingFlag") Integer samplingFlag,
            @RequestBody TbCheckInfo tbCheckInfo,
            HttpServletResponse res
    ) throws Exception {
        tbCheckInfoService.outExcel(tbCheckInfo,samplingFlag,res);
    }

}
