package com.yc.demo.service.impl;

import com.yc.demo.domain.TbAcl;
import com.yc.demo.domain.TbAclExample;
import com.yc.demo.domain.ex.TbAclEx;
import com.yc.demo.mapper.TbAclMapper;
import com.yc.demo.service.AclService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName AclServiceImpl
 * @Date 2021/5/31 17:15
 * @Description：
 */
@Service
public class AclServiceImpl implements AclService {
    @Autowired
    private TbAclMapper tbAclMapper;
    @Override
    public void insert(TbAcl acl) {
        acl.setCreateTime(new Date());
        tbAclMapper.insert(acl);
    }

    @Override
    public void updateById(TbAcl acl) {
        tbAclMapper.updateByPrimaryKeySelective(acl);
    }

    @Override
    public List<TbAcl> select(TbAclEx acl) {
        TbAclExample example=new TbAclExample();
        TbAclExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(acl.getNameLike())){
            criteria.andAclNameLike("%"+acl.getNameLike()+"%");
        }
        if(acl.getId()!=null){
            criteria.andIdEqualTo(acl.getId());
        }
        if(StringUtils.isNotEmpty(acl.getAclCode())){
            criteria.andAclCodeEqualTo(acl.getAclCode());
        }
        if(StringUtils.isNotEmpty(acl.getAclUrl())){
            criteria.andAclUrlEqualTo(acl.getAclUrl());
        }
        if(StringUtils.isNotEmpty(acl.getAclName())){
            criteria.andAclNameEqualTo(acl.getAclName());
        }
        if(!CollectionUtils.isEmpty(acl.getAclCodes())){
            criteria.andAclCodeIn(acl.getAclCodes());
        }
        return tbAclMapper.selectByExample(example);
    }
}
