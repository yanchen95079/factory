package com.yc.demo.controller;

import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbUser;
import com.yc.demo.service.TbConfigService;
import com.yc.demo.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yanchen
 * date 2021/3/21 4:07
 */
@RestController
@Api(tags = "user控制层")
@RequestMapping(value = "/user")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @ApiOperation("查看user信息")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(
            @RequestBody TbUser tbUser
    ) throws Exception {
        return new HSResult(tbUserService.select(tbUser));
    }


    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HSResult login(
            @RequestBody TbUser tbUser
    ) throws Exception {
        return new HSResult(tbUserService.login(tbUser));
    }

    @ApiOperation("添加user信息")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(
            @RequestBody TbUser tbUser
    ) throws Exception {
        tbUserService.insert(tbUser);
        return HSResult.ok();
    }

    @ApiOperation("更新config信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult update(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TbUser tbUser
    ) throws Exception {
        tbUser.setId(id);
        tbUserService.update(tbUser);
        return HSResult.ok();
    }
}
