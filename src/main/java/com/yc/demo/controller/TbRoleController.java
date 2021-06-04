package com.yc.demo.controller;


import com.yc.demo.commom.HSResult;
import com.yc.demo.domain.TbAcl;
import com.yc.demo.domain.TbAclRoleRelation;
import com.yc.demo.domain.TbRole;
import com.yc.demo.domain.TbUserRoleRelation;
import com.yc.demo.domain.ex.TbAclEx;
import com.yc.demo.domain.ex.TbRoleEx;
import com.yc.demo.service.AclService;
import com.yc.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbRoleController
 * @Date 2021/3/5 15:42
 * @Description：
 */
@RestController
@Api(tags = "role控制层")
@RequestMapping(value = "/role")
public class TbRoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("查询角色")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public HSResult select(
            @RequestBody TbRoleEx role
    ) throws Exception {
        return new HSResult(roleService.select(role));
    }

    @ApiOperation("新建角色")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HSResult insert(
            @RequestBody TbRole role
    ) throws Exception {
        roleService.insert(role);
        return HSResult.ok();
    }

    @ApiOperation("更新角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public HSResult update(
            @ApiParam(value = "id") @PathVariable(value = "id") Long id,
            @RequestBody TbRole role
    ) throws Exception {
        role.setId(id);
        roleService.updateById(role);
        return HSResult.ok();
    }

    @ApiOperation("绑定角色和人关系")
    @RequestMapping(value = "/bindUser/{roleCode}", method = RequestMethod.POST)
    public HSResult bindUser(
            @ApiParam(value = "roleCode") @PathVariable(value = "roleCode") String roleCode,
            @RequestParam List<TbUserRoleRelation> list
    ) throws Exception {
        roleService.updateUserRoleRelation(list,roleCode);
        return HSResult.ok();
    }
    @ApiOperation("绑定角色和权限关系")
    @RequestMapping(value = "/bindAcl/{roleCode}", method = RequestMethod.POST)
    public HSResult bindAcl(
            @ApiParam(value = "roleCode") @PathVariable(value = "roleCode") String roleCode,
            @RequestParam List<TbAclRoleRelation> list
    ) throws Exception {
        roleService.updateAclRoleRelation(list,roleCode);
        return HSResult.ok();
    }


    @ApiOperation("查询角色下的人")
    @RequestMapping(value = "/selectUserByRole/{roleCode}", method = RequestMethod.POST)
    public HSResult selectUserByRole(
            @ApiParam(value = "roleCode") @PathVariable(value = "roleCode") String roleCode
    ) throws Exception {
        return new HSResult(roleService.selectUserRoleRelation(roleCode));
    }
    @ApiOperation("查询角色下的权限")
    @RequestMapping(value = "/selectAclByRole/{roleCode}", method = RequestMethod.POST)
    public HSResult selectAclByRole(
            @ApiParam(value = "roleCode") @PathVariable(value = "roleCode") String roleCode
    ) throws Exception {
        return new HSResult(roleService.selectAclRoleRelation(roleCode));
    }
}
