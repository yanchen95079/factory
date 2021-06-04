package com.yc.demo.controller;


import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbAcl;
import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.ex.TbAclEx;
import com.yc.demo.service.AclService;
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
 * @ClassName TbAclController
 * @Date 2021/3/5 15:42
 * @Description：
 */
@RestController
@Api(tags = "acl控制层")
@RequestMapping(value = "/acl")
public class TbAclController {
    @Autowired
    private AclService aclService;

   @ApiOperation("查询权限")
   @RequestMapping(value = "/select", method = RequestMethod.POST)
   public HSResult select(
           @RequestBody TbAclEx tbAcl
   ) throws Exception {
       return new HSResult(aclService.select(tbAcl));
   }

    @ApiOperation("新建权限")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(
            @RequestBody TbAcl tbAcl
    ) throws Exception {
        aclService.insert(tbAcl);
        return HSResult.ok();
    }

    @ApiOperation("更新权限")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult update(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TbAcl tbAcl
    ) throws Exception {
        tbAcl.setId(id);
        aclService.updateById(tbAcl);
        return HSResult.ok();
    }

}
