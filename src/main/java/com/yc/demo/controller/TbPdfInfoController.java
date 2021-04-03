package com.yc.demo.controller;


import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbPdfInfo;
import com.yc.demo.service.TbPdfInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yanchen
 * date 2018/8/6 17:16
 */
@RestController
@Api(tags = "pdf控制层")
@RequestMapping(value = "/pdfInfo")
public class TbPdfInfoController {
    @Autowired
    private TbPdfInfoService tbPdfInfoService;

    @ApiOperation("查看PDF")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(

            @RequestBody TbPdfInfo tbPdfInfo
    ) throws Exception {
        return new HSResult(tbPdfInfoService.select(tbPdfInfo));
    }

    @ApiOperation("查看ById")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public HSResult selectById(

            @RequestParam Long id
    ) throws Exception {
        return new HSResult(tbPdfInfoService.selectById(id));
    }

    @ApiOperation("添加PDF")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(

            @RequestBody TbPdfInfo tbPdfInfo
    ) throws Exception {
        tbPdfInfoService.insert(tbPdfInfo);
        return HSResult.ok();
    }

    @ApiOperation("更新PDF")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public HSResult update(

            @RequestBody TbPdfInfo tbPdfInfo
    ) throws Exception {
        tbPdfInfoService.update(tbPdfInfo);
        return HSResult.ok();
    }

    @ApiOperation("导出PDF")
    @RequestMapping(value = "/pdfOut", method = RequestMethod.POST)
    public HSResult pdfOut(
            @RequestParam Long id
    ) throws Exception {
        tbPdfInfoService.pdfOut(id);
        return HSResult.ok();
    }
}
