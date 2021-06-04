package com.yc.demo.service;

import com.yc.demo.domain.TbAclRoleRelation;
import com.yc.demo.domain.TbRole;
import com.yc.demo.domain.TbUserRoleRelation;
import com.yc.demo.domain.ex.TbAclRoleRelationEx;
import com.yc.demo.domain.ex.TbRoleEx;
import com.yc.demo.domain.ex.TbUserEx;
import com.yc.demo.domain.ex.TbUserRoleRelationEx;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName RoleService
 * @Date 2021/5/31 15:14
 * @Description：
 */
public interface RoleService {
    void insert(TbRole role);

    void updateById(TbRole role);

    void deleteById(Long roleId);

    List<TbRole> select(TbRoleEx role);


    void updateUserRoleRelation(List<TbUserRoleRelation> list,String roleCode);

    void updateAclRoleRelation(List<TbAclRoleRelation> list,String roleCode);

    List<TbUserRoleRelationEx> selectUserRoleRelation(String roleCode);

    List<TbAclRoleRelationEx> selectAclRoleRelation(String roleCode);

    TbUserEx selectAclByUserCode(Long userCode);
}
