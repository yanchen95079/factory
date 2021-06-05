package com.yc.demo.service;

import com.github.pagehelper.PageInfo;
import com.yc.demo.domain.TbAclRoleRelation;
import com.yc.demo.domain.TbRole;
import com.yc.demo.domain.TbUserRoleRelation;
import com.yc.demo.domain.ex.*;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName RoleService
 * @Date 2021/5/31 15:14
 * @Description：
 */
public interface RoleService {
    TbRole insert(TbRole role);

    void updateById(TbRole role);

    void deleteById(Long roleId);

    List<TbRole> select(TbRoleEx role);

    PageInfo<TbRole> selectPage(TbRolePage tbRolePage );
    void updateUserRoleRelation(List<TbUserRoleRelation> list,String roleCode);

    void updateAclRoleRelation(List<TbAclRoleRelation> list,String roleCode);

    List<TbUserRoleRelationEx> selectUserRoleRelation(String roleCode);

    List<TbAclRoleRelationEx> selectAclRoleRelation(String roleCode);

    TbUserEx selectAclByUserCode(Long userCode);
}
