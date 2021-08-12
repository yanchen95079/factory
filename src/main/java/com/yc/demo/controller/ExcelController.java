package com.yc.demo.controller;

import com.yc.demo.domain.ex.TbOrderGeneralExcelPojo;
import com.yc.demo.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Yanchen
 * date 2021/8/12 13:59
 */
@RestController
@Api(tags = "excel控制层")
@RequestMapping(value = "/excel")
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @ApiOperation("料号Excel导入")
    @RequestMapping(value = "/materialNumberEnum", method = RequestMethod.POST)
    public void materialNumberEnum(
            @RequestParam("file") MultipartFile multipartFile,
            HttpServletResponse res
    ) throws Exception {
        excelService.materialNumberEnum(multipartFile);
    }

    @ApiOperation("各种单据导出Excel")
    @RequestMapping(value = "/orderOutExcel", method = RequestMethod.POST)
    public void outExcel(
            @RequestBody TbOrderGeneralExcelPojo tbOrderGeneralExcelPojo,
            HttpServletResponse res
    ) throws Exception {
        excelService.orderOutExcel(tbOrderGeneralExcelPojo,res);
    }
}
