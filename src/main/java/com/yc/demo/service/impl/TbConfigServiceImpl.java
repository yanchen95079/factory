package com.yc.demo.service.impl;

import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbConfigExample;
import com.yc.demo.mapper.TbConfigMapper;
import com.yc.demo.service.TbConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Yanchen
 * @ClassName TbConfigService
 * @Date 2021/2/25 11:58
 * @Description：
 */
@Service
public class TbConfigServiceImpl implements TbConfigService {
    @Autowired
    private TbConfigMapper tbConfigMapper;


    @Override
    public List<TbConfig> select(TbConfig config) {
        TbConfigExample example=new TbConfigExample();
        TbConfigExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(config.getConfigKey())){
            criteria.andConfigKeyEqualTo(config.getConfigKey());
        }
        if(StringUtils.isNotEmpty(config.getConfigType())){
            criteria.andConfigTypeEqualTo(config.getConfigType());
        }
        return  tbConfigMapper.selectByExample(example);
    }

    @Override
    public void insert(TbConfig config) {
        if(StringUtils.isEmpty(config.getConfigKey())){
            config.setConfigKey(UUID.randomUUID().toString());
        }
        config.setCreateTime(new Date());
        config.setUpdateTime(new Date());
        tbConfigMapper.insertSelective(config);
    }

    @Override
    public void update(TbConfig config) {
        tbConfigMapper.updateByPrimaryKeySelective(config);
    }
}
