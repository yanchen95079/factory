package com.yc.demo.service.impl;

import com.yc.demo.commom.exception.MyException;
import com.yc.demo.commom.utils.CryptoUtil;
import com.yc.demo.commom.utils.HexUtil;
import com.yc.demo.commom.utils.IdUtil;
import com.yc.demo.domain.TbUser;
import com.yc.demo.domain.TbUserExample;
import com.yc.demo.mapper.TbUserMapper;
import com.yc.demo.service.TbUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * date 2021/3/21 3:53
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;


    @Override
    public List<TbUser> select(TbUser tbUser) {
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbUser.getPhone())){
            criteria.andPhoneEqualTo(tbUser.getPhone());
        }
        if(StringUtils.isNotEmpty(tbUser.getPassword())){
            criteria.andPasswordEqualTo(CryptoUtil.md5Hex(tbUser.getPassword()));
        }
        if(tbUser.getUserCode()!=null){
            criteria.andUserCodeEqualTo(tbUser.getUserCode());
        }
        return tbUserMapper.selectByExample(example);
    }

    @Override
    public Map<Long, String> selectAllUserName() {
        List<TbUser> select = this.select(new TbUser());
        return select.stream().collect(Collectors.toMap(TbUser::getUserCode,TbUser::getUserName));
    }



    @Override
    public void insert(TbUser tbUser) {
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(tbUser.getPhone());
        example.or(criteria);
        TbUserExample.Criteria criteria2 = example.createCriteria();
        criteria2.andLoginCodeEqualTo(tbUser.getLoginCode());
        example.or(criteria2);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(tbUsers)){
            throw new MyException(500,"存在此用户,请确认手机号或者用户名");
        }
        tbUser.setUserCode(IdUtil.generateHighId());
        tbUser.setPassword(CryptoUtil.md5Hex(tbUser.getPassword()));
        tbUser.setCreateTime(new Date());
        tbUser.setUpdateTime(new Date());
        tbUserMapper.insert(tbUser);
    }

    @Override
    public void update(TbUser tbUser) {
        TbUserExample example=new TbUserExample();
        if(StringUtils.isNotEmpty(tbUser.getPhone())){
            TbUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(tbUser.getPhone());
            example.or(criteria);
        }
        if(StringUtils.isNotEmpty(tbUser.getLoginCode())){
            TbUserExample.Criteria criteria2 = example.createCriteria();
            criteria2.andLoginCodeEqualTo(tbUser.getLoginCode());
            example.or(criteria2);
        }
        if(StringUtils.isNotEmpty(tbUser.getPhone()) ||StringUtils.isNotEmpty(tbUser.getLoginCode())){
            List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(tbUsers)){
                List<TbUser> tbUsersFinal=tbUsers.stream().filter(x->!x.getId().equals(tbUser.getId())).collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(tbUsersFinal)){
                    throw new MyException(500,"存在此用户,请确认手机号或者用户名");
                }
            }
        }
        if(StringUtils.isNotEmpty(tbUser.getPassword())){
            tbUser.setPassword(CryptoUtil.md5Hex(tbUser.getPassword()));
        }
        tbUser.setUpdateTime(new Date());
        tbUserMapper.updateByPrimaryKeySelective(tbUser);
    }

    @Override
    public TbUser login(TbUser tbUser) {
        if(StringUtils.isEmpty(tbUser.getPhone())&&StringUtils.isEmpty(tbUser.getLoginCode())){
            throw new MyException(500,"手机号和登录号至少输入一个");
        }
        if(StringUtils.isEmpty(tbUser.getPassword())){
            throw new MyException(500,"请输入密码");
        }
        TbUserExample example=new TbUserExample();
        if(StringUtils.isNotEmpty(tbUser.getPhone())){
            TbUserExample.Criteria criteria = example.createCriteria();
            criteria.andPhoneEqualTo(tbUser.getPhone());
            criteria.andPasswordEqualTo(CryptoUtil.md5Hex(tbUser.getPassword()));
            example.or(criteria);
        }
        if(StringUtils.isNotEmpty(tbUser.getLoginCode())){
            TbUserExample.Criteria criteria2 = example.createCriteria();
            criteria2.andLoginCodeEqualTo(tbUser.getLoginCode());
            criteria2.andPasswordEqualTo(CryptoUtil.md5Hex(tbUser.getPassword()));
            example.or(criteria2);
        }

        List<TbUser> select = tbUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(select)){
            throw new MyException(500,"用户不存在");
        }
        return select.get(0);
    }
}
