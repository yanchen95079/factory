package com.yc.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbMapRelation;
import com.yc.demo.domain.TbMapRelationExample;
import com.yc.demo.domain.ex.MapRelationPojo;
import com.yc.demo.domain.ex.TbMapRelationForm;
import com.yc.demo.mapper.TbMapRelationMapper;
import com.yc.demo.service.TbConfigService;
import com.yc.demo.service.TbMapRelationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * date 2021/4/4 0:09
 */
@Service
@Slf4j
public class TbMapRelationServiceImpl implements TbMapRelationService {
    @Autowired
    private TbMapRelationMapper tbMapRelationMapper;
    @Autowired
    private TbConfigService tbConfigService;


    @Override
    public void insert(MapRelationPojo mapRelationPojo) throws Exception{
        TbConfig metaParam = new TbConfig();
        metaParam.setConfigType(mapRelationPojo.getConfigType());
        List<TbConfig> metaConfigList = tbConfigService.select(metaParam);
        TbMapRelationForm mapParam=new TbMapRelationForm();
        mapParam.setConfigType(mapRelationPojo.getConfigType());
        if (metaConfigList == null || metaConfigList.size() == 0) {
            throw new MyException(500, "找不到对应元配置类型的配置项,configType=" + mapRelationPojo.getConfigType());
        } else {
            for (TbConfig config : metaConfigList) {
                String level = config.getConfigValue();
                if (StringUtils.isNotBlank(level)) {
                    //按照传进来的参数，参照元数据类型，放到对应的位置上
                    try {
                        Field f = TbMapRelation.class.getDeclaredField("level" + level);
                        f.setAccessible(true);
                        f.set(mapParam, mapRelationPojo.getMap().get(config.getConfigKey()));
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        log.error("insert按照级别组装参数数据过程中出错，错误原因{},config 参数{}，condition参数 {}", e, config, mapRelationPojo.getMap());
                        throw e;
                    }
                }
            }
        }
        tbMapRelationMapper.insertSelective(mapParam);
    }

    @Override
    public void updateById(MapRelationPojo mapRelationPojo) throws Exception{
        TbConfig metaParam = new TbConfig();
        metaParam.setConfigType(mapRelationPojo.getConfigType());
        List<TbConfig> metaConfigList = tbConfigService.select(metaParam);
        TbMapRelationForm mapParam=new TbMapRelationForm();
        mapParam.setId(mapRelationPojo.getId());
        mapParam.setPosition(mapRelationPojo.getPosition());
        if (metaConfigList == null || metaConfigList.size() == 0) {
            throw new MyException(500, "找不到对应元配置类型的配置项,configType=" + mapRelationPojo.getConfigType());
        } else {
            for (TbConfig config : metaConfigList) {
                String level = config.getConfigValue();
                if (StringUtils.isNotBlank(level)) {
                    //按照传进来的参数，参照元数据类型，放到对应的位置上
                    try {
                        Field f = TbMapRelation.class.getDeclaredField("level" + level);
                        f.setAccessible(true);
                        f.set(mapParam, mapRelationPojo.getMap().get(config.getConfigKey()));
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        log.error("updateById按照级别组装参数数据过程中出错，错误原因{},config 参数{}，condition参数 {}", e, config, mapRelationPojo.getMap());
                        throw e;
                    }
                }
            }
        }
        tbMapRelationMapper.updateByPrimaryKeySelective(mapParam);
    }

    @Override
    public void delById(Long id) {
        tbMapRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delAndBatchInsert(TbMapRelation mapUpdate, List<TbMapRelation> list) {
        if(mapUpdate!=null){
            TbMapRelationExample example=new TbMapRelationExample();
            TbMapRelationExample.Criteria criteria = example.createCriteria();
            if(mapUpdate.getId()!=null){
                criteria.andIdEqualTo(mapUpdate.getId());
            }
            if(StringUtils.isNotEmpty(mapUpdate.getConfigType())){
                criteria.andConfigTypeEqualTo(mapUpdate.getConfigType());
            }
            if(StringUtils.isNotEmpty(mapUpdate.getLevel1())){
                criteria.andLevel1EqualTo(mapUpdate.getLevel1());
            }
            if(StringUtils.isNotEmpty(mapUpdate.getLevel2())){
                criteria.andLevel2EqualTo(mapUpdate.getLevel2());
            }
            if(StringUtils.isNotEmpty(mapUpdate.getLevel3())){
                criteria.andLevel3EqualTo(mapUpdate.getLevel3());
            }
            tbMapRelationMapper.deleteByExample(example);

        }
        if(!CollectionUtils.isEmpty(list)){
            this.batchInsert(list);
        }
    }

    @Override
    public void batchInsert(List<TbMapRelation> list) {
        Date date=new Date();
        list.forEach(x->{
            x.setCreateTime(date);
            x.setUpdateTime(date);
            if(x.getPosition()==null){
                x.setPosition(0);
            }
        });
        tbMapRelationMapper.batchInsert(list);
    }

    @Override
    public List<TbMapRelation> select(TbMapRelationForm tbMapRelation) {
        TbMapRelationExample example=new TbMapRelationExample();
        TbMapRelationExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbMapRelation.getConfigType())){
            criteria.andConfigTypeEqualTo(tbMapRelation.getConfigType());
        }
        if(StringUtils.isNotEmpty(tbMapRelation.getLevel1())){
            criteria.andLevel1EqualTo(tbMapRelation.getLevel1());
        }
        if(StringUtils.isNotEmpty(tbMapRelation.getLevel2())){
            criteria.andLevel2EqualTo(tbMapRelation.getLevel2());
        }
        if(StringUtils.isNotEmpty(tbMapRelation.getLevel3())){
            criteria.andLevel3EqualTo(tbMapRelation.getLevel3());
        }
        if(StringUtils.isNotEmpty(tbMapRelation.getLevel2in())){
            criteria.andLevel2In(JSON.parseArray(tbMapRelation.getLevel2in(),String.class));
        }
        if(StringUtils.isNotEmpty(tbMapRelation.getOrderBy())){
            example.setOrderByClause(tbMapRelation.getOrderBy());
        }
        return tbMapRelationMapper.selectByExample(example);
    }

    @Override
    public  List<String> getMapLikeRelation(String configType, Map<String,String> condition, Map<String,String> likeCondition,Map<String,String> inCondition) throws Exception {
        TbConfig metaParam = new TbConfig();
        metaParam.setConfigType(configType);
        List<TbConfig> metaConfigList = tbConfigService.select(metaParam);
        TbMapRelationForm mapParam=new TbMapRelationForm();
        mapParam.setConfigType(configType);
        if (metaConfigList == null || metaConfigList.size() == 0) {
            throw new MyException(500, "找不到对应元配置类型的配置项,configType=" + configType);
        } else {
            if (condition != null && condition.size() > 0) {
                for (TbConfig config : metaConfigList) {
                    String level = config.getConfigValue();
                    if (StringUtils.isNotBlank(level)) {
                        //按照传进来的参数，参照元数据类型，放到对应的位置上
                        try {
                            Field f = TbMapRelation.class.getDeclaredField("level" + level);
                            f.setAccessible(true);
                            f.set(mapParam, condition.get(config.getConfigKey()));
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            log.error("按照级别组装参数数据过程中出错，错误原因{},config 参数{}，condition参数 {}", e, config, condition);
                            throw e;
                        }
                    }
                }
            }


            if (likeCondition != null && likeCondition.size() > 0) {
                for (TbConfig config : metaConfigList) {
                    String level = config.getConfigValue();
                    if (StringUtils.isNotBlank(level)) {
                        //按照传进来的参数，参照元数据类型，放到对应的位置上
                        try {
                            Field f = TbMapRelationForm.class.getDeclaredField("level" + level+"like");
                            f.setAccessible(true);
                            f.set(mapParam, likeCondition.get(config.getConfigKey()));
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            log.error("按照级别组装参数数据过程中出错，错误原因{},config 参数{}，conditionLike参数 {}", e, config, condition);
                            throw e;
                        }
                    }
                }
            }

            if (inCondition != null && inCondition.size() > 0) {
                for (TbConfig config : metaConfigList) {
                    String level = config.getConfigValue();
                    if (StringUtils.isNotBlank(level)) {
                        //按照传进来的参数，参照元数据类型，放到对应的位置上
                        try {
                            Field f = TbMapRelationForm.class.getDeclaredField("level" + level+"in");
                            f.setAccessible(true);
                            f.set(mapParam, inCondition.get(config.getConfigKey()));
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            log.error("按照级别组装参数数据过程中出错，错误原因{},config 参数{}，conditionLike参数 {}", e, config, condition);
                            throw e;
                        }
                    }
                }
            }

            if(condition != null && condition.size() > 0 && condition.get("order") != null){
                String sort = condition.get("order");
                String orderBy = " position " + sort;
                mapParam.setOrderBy(orderBy);
            }else {
                mapParam.setOrderBy(" position asc");
            }
            List<TbMapRelation> mapRelationList = this.select(mapParam);
            mapRelationList=mapRelationList.stream().sorted(Comparator.comparing(TbMapRelation::getPosition)).collect(Collectors.toList());
            //按照结构封装对应的json
            List<String> resultList = new ArrayList<>();
            for (TbMapRelation mapRelation : mapRelationList) {
                Map<String,Object> jsonObject = new HashMap();
                jsonObject.put("id", mapRelation.getId());
                for (TbConfig metaConfig : metaConfigList) {
                    Field f = TbMapRelation.class.getDeclaredField(
                            "level" + metaConfig
                                    .getConfigValue());
                    f.setAccessible(true);
                    jsonObject.put(metaConfig.getConfigKey(), f.get(mapRelation));
                }
                jsonObject.put("enable",mapRelation.getEnable());
                jsonObject.put("position",mapRelation.getPosition());
                resultList.add(JSON.toJSONString(jsonObject,SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue));
            }
            return resultList;

        }
    }
    @Override
    public <T> List<T> getMapRelation(String configType, Map<String,String> condition, Map<String,String> likeCondition,Map<String,String> inCondition,Class<T> clazz) throws Exception {
        List<T> resultList = new ArrayList<>();
        List<String> strList = getMapLikeRelation(configType, condition,likeCondition,inCondition);
        if (!CollectionUtils.isEmpty(strList)) {
            for (String str : strList) {
                resultList.add(JSON.parseObject(str, clazz));
            }
        }
        return resultList;
    }
}
