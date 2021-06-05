package com.yc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.*;
import com.yc.demo.mapper.TbAclRoleRelationMapper;
import com.yc.demo.mapper.TbRoleMapper;
import com.yc.demo.mapper.TbUserRoleRelationMapper;
import com.yc.demo.service.AclService;
import com.yc.demo.service.RoleService;
import com.yc.demo.service.TbUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * @ClassName RoleServiceImpl
 * @Date 2021/5/31 15:20
 * @Description：
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private TbRoleMapper roleMapper;
    @Autowired
    private TbUserRoleRelationMapper tbUserRoleRelationMapper;
    @Autowired
    private TbAclRoleRelationMapper tbAclRoleRelationMapper;
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private AclService aclService;
    @Override
    public TbRole insert(TbRole role) {
        if(StringUtils.isEmpty(role.getRoleCode())){
            role.setRoleCode("ROLE"+UUID.randomUUID().toString().replaceAll("-",""));
        }
        role.setpRoleCode("0");
        role.setCodes("0,");
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        roleMapper.insertSelective(role);
        return role;
    }

    @Override
    public void updateById(TbRole role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void deleteById(Long roleId) {
        TbRoleEx role=new TbRoleEx();
        role.setId(roleId);
        List<TbRole> select = this.select(role);
        if(CollectionUtils.isEmpty(select)){
            throw new MyException(500,"没有找到对应的角色");
        }
        List<TbUserRoleRelationEx> tbUserRoleRelationExes = this.selectUserRoleRelation(select.get(0).getRoleCode());
        if(!CollectionUtils.isEmpty(tbUserRoleRelationExes)){
            throw new MyException(500,"角色下有关联的人,不可删除");
        }
        List<TbAclRoleRelationEx> tbAclRoleRelationExes = this.selectAclRoleRelation(select.get(0).getRoleCode());
        if(!CollectionUtils.isEmpty(tbAclRoleRelationExes)){
            throw new MyException(500,"角色下有关联的权限,不可删除");
        }
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public List<TbRole> select(TbRoleEx role) {
        TbRoleExample example=new TbRoleExample();
        TbRoleExample.Criteria criteria = example.createCriteria();
        if(role.getId()!=null){
            criteria.andIdEqualTo(role.getId());
        }
        if(StringUtils.isNotEmpty(role.getRoleName())){
            criteria.andRoleNameEqualTo(role.getRoleName());
        }
        if(StringUtils.isNotEmpty(role.getRoleCode())){
            criteria.andRoleCodeEqualTo(role.getRoleCode());
        }
        if(!CollectionUtils.isEmpty(role.getRoleCodes())){
            criteria.andRoleCodeIn(role.getRoleCodes());
        }
        return roleMapper.selectByExample(example);
    }

    @Override
    public PageInfo<TbRole> selectPage(TbRolePage role) {
        TbRoleExample example=new TbRoleExample();
        TbRoleExample.Criteria criteria = example.createCriteria();
        if(role.getId()!=null){
            criteria.andIdEqualTo(role.getId());
        }
        if(StringUtils.isNotEmpty(role.getRoleName())){
            criteria.andRoleNameEqualTo(role.getRoleName());
        }
        if(StringUtils.isNotEmpty(role.getRoleCode())){
            criteria.andRoleCodeEqualTo(role.getRoleCode());
        }
        PageHelper.startPage(role.getOffset(), role.getLimit());
        List<TbRole> tbRoles = roleMapper.selectByExample(example);
        return new PageInfo<>(tbRoles);

    }

    @Override
    public void updateUserRoleRelation(List<TbUserRoleRelation> list, String roleCode) {
        TbUserRoleRelationExample example=new TbUserRoleRelationExample();
        TbUserRoleRelationExample.Criteria criteria = example.createCriteria();
        criteria.andRoleCodeEqualTo(roleCode);
        tbUserRoleRelationMapper.deleteByExample(example);
        list.forEach(x->{
            x.setRoleCode(roleCode);
            x.setCreateTime(new Date());
        });
        tbUserRoleRelationMapper.batchInsert(list);
    }

    @Override
    public void updateAclRoleRelation(List<TbAclRoleRelation> list, String roleCode) {
        TbAclRoleRelationExample example=new TbAclRoleRelationExample();
        TbAclRoleRelationExample.Criteria criteria = example.createCriteria();
        criteria.andRoleCodeEqualTo(roleCode);
        tbAclRoleRelationMapper.deleteByExample(example);
        list.forEach(x->{
            x.setRoleCode(roleCode);
            x.setCreateTime(new Date());
        });
        tbAclRoleRelationMapper.batchInsert(list);
    }

    @Override
    public List<TbUserRoleRelationEx> selectUserRoleRelation(String roleCode) {
        TbUserRoleRelationExample example=new TbUserRoleRelationExample();
        TbUserRoleRelationExample.Criteria criteria = example.createCriteria();
        criteria.andRoleCodeEqualTo(roleCode);
        List<TbUserRoleRelation> tbUserRoleRelations = tbUserRoleRelationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tbUserRoleRelations)){
            return new ArrayList<TbUserRoleRelationEx>();
        }
        List<Long> userCodes = tbUserRoleRelations.stream().map(x->Long.valueOf(x.getUserCode())).collect(Collectors.toList());
        TbUserEx tbUser=new TbUserEx();
        tbUser.setUserCodes(userCodes);
        List<TbUser> tbUsers = tbUserService.selectEx(tbUser);
        Map<Long, String> map = tbUsers.stream().collect(Collectors.toMap(TbUser::getUserCode, TbUser::getUserName));

        List<TbUserRoleRelationEx> list=new ArrayList<>();
        for (TbUserRoleRelation tbUserRoleRelation : tbUserRoleRelations) {
            TbUserRoleRelationEx ex=new TbUserRoleRelationEx();
            BeanUtils.copyProperties(tbUserRoleRelation,ex);
            ex.setUserName(map.get(Long.valueOf(tbUserRoleRelation.getUserCode())));
            list.add(ex);
        }
        return list;
    }

    @Override
    public List<TbAclRoleRelationEx> selectAclRoleRelation(String roleCode) {
        TbAclRoleRelationExample example=new TbAclRoleRelationExample();
        TbAclRoleRelationExample.Criteria criteria = example.createCriteria();
        criteria.andRoleCodeEqualTo(roleCode);
        List<TbAclRoleRelation> tbAclRoleRelations = tbAclRoleRelationMapper.selectByExample(example);

        List<String> aclCodes = tbAclRoleRelations.stream().map(TbAclRoleRelation::getAclCode).collect(Collectors.toList());
        TbAclEx acl =new TbAclEx();
        acl.setAclCodes(aclCodes);
        List<TbAcl> select = aclService.select(acl);
        Map<String, String> map = select.stream().collect(Collectors.toMap(TbAcl::getAclCode, TbAcl::getAclName));

        List<TbAclRoleRelationEx> list=new ArrayList<>();
        for (TbAclRoleRelation tbAclRoleRelation : tbAclRoleRelations) {
            TbAclRoleRelationEx ex=new TbAclRoleRelationEx();
            BeanUtils.copyProperties(tbAclRoleRelation,ex);
            ex.setAclName(map.get(tbAclRoleRelation.getAclCode()));
            list.add(ex);
        }
        return list;
    }

    @Override
    public TbUserEx selectAclByUserCode(Long userCode) {
        TbUserEx ex=new TbUserEx();
        //获取人下面的角色
        TbUserRoleRelationExample example=new TbUserRoleRelationExample();
        TbUserRoleRelationExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(String.valueOf(userCode));
        List<TbUserRoleRelation> tbUserRoleRelations = tbUserRoleRelationMapper.selectByExample(example);
        List<String> roleCodes = tbUserRoleRelations.stream().map(TbUserRoleRelation::getRoleCode).collect(Collectors.toList());
        TbRoleEx role=new TbRoleEx();
        role.setRoleCodes(roleCodes);
        List<TbRole> roles = this.select(role);
        ex.setRoleList(roles);
        if(CollectionUtils.isEmpty(roles)){
            return ex;
        }
        //拿到角色下的权限
        TbAclRoleRelationExample example2=new TbAclRoleRelationExample();
        TbAclRoleRelationExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andRoleCodeIn(roleCodes);
        List<TbAclRoleRelation> tbAclRoleRelations = tbAclRoleRelationMapper.selectByExample(example2);
        List<String> aclCodes = tbAclRoleRelations.stream().map(TbAclRoleRelation::getAclCode).collect(Collectors.toList());
        TbAclEx aclEx=new TbAclEx();
        aclEx.setAclCodes(aclCodes);
        ex.setAclList( aclService.select(aclEx));
        return ex;
    }
}
