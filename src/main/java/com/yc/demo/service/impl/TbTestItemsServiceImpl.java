package com.yc.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.commom.mapstruct.convert.Convert;
import com.yc.demo.commom.utils.DateUtil;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.AssemblyContentForm;
import com.yc.demo.domain.ex.ItemEnumPoJo;
import com.yc.demo.domain.ex.TestItemsForm;
import com.yc.demo.mapper.TbTestItemsMapper;
import com.yc.demo.service.TbAssemblyContentService;
import com.yc.demo.service.TbCheckInfoService;
import com.yc.demo.service.TbMapRelationService;
import com.yc.demo.service.TbTestItemsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * @ClassName TbTestItemsServiceImpl
 * @Date 2021/2/25 12:04
 * @Description：
 */
@Service
@Slf4j
public class TbTestItemsServiceImpl implements TbTestItemsService {
    @Autowired
    private TbMapRelationService tbMapRelationService;
    @Autowired
    private TbTestItemsMapper tbTestItemsMapper;
    @Autowired
    private TbCheckInfoService tbCheckInfoService;
    @Autowired
    private TbAssemblyContentService tbAssemblyContentService;
    @Autowired
    private Convert convert;
    @Override
    public List<TbTestItems> select(TbTestItems tbTestItems) {
        TbTestItemsExample example=new TbTestItemsExample();
        TbTestItemsExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbTestItems.getConfigKey())){
            criteria.andConfigKeyEqualTo(tbTestItems.getConfigKey());
        }
        if(tbTestItems.getAssemblyContentId()!=null){
            criteria.andAssemblyContentIdEqualTo(tbTestItems.getAssemblyContentId());
        }
        example.setOrderByClause(" position asc");
        return tbTestItemsMapper.selectByExample(example);
    }

    @Override
    public List<TbTestItems> selectByAssemblyContentIds(List<Long> assemblyContentIds) {
        TbTestItemsExample example=new TbTestItemsExample();
        TbTestItemsExample.Criteria criteria = example.createCriteria();
        criteria.andAssemblyContentIdIn(assemblyContentIds);
        example.setOrderByClause(" position asc");
        return tbTestItemsMapper.selectByExample(example);
    }

    @Override
    public List<TestItemsForm> selectAll(TestItemsForm tbTestItems) {
        TbTestItemsExample example=new TbTestItemsExample();
        TbTestItemsExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbTestItems.getConfigKey())){
            criteria.andConfigKeyEqualTo(tbTestItems.getConfigKey());
        }
        if(tbTestItems.getAssemblyContentId()!=null){
            criteria.andAssemblyContentIdEqualTo(tbTestItems.getAssemblyContentId());
        }
        if(tbTestItems.getId()!=null){
            criteria.andIdEqualTo(tbTestItems.getId());
        }
        if(!CollectionUtils.isEmpty(tbTestItems.getAssemblyContentIds())){
            criteria.andAssemblyContentIdIn(tbTestItems.getAssemblyContentIds());
        }
        example.setOrderByClause(" position asc");
        List<TbTestItems> tbTestItems1 = tbTestItemsMapper.selectByExample(example);
        List<TestItemsForm> result=convert.tbTestItemsToForm(tbTestItems1);
        if(CollectionUtils.isEmpty(result)){
            return result;
        }
        //将装配信息名称填入
        List<Long> ids = tbTestItems1.stream().map(TbTestItems::getAssemblyContentId).collect(Collectors.toList());
        AssemblyContentForm form=new AssemblyContentForm();
        form.setIds(ids);
        List<TbAssemblyContent> select = tbAssemblyContentService.select(form);
        Map<Long, String> map = select.stream().collect(Collectors.toMap(TbAssemblyContent::getId, TbAssemblyContent::getContentName));
        try {
        //获取枚举
        Map<String,String> mapParam=new HashMap<>(2);
        List<Long> idList=new ArrayList<>();
        idList.add(Long.valueOf(CommonConstant.ZERO));
        List<Long> collect = result.stream().filter(x -> x.getItemType() != 0).map(TestItemsForm::getId).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(collect)){
            idList.addAll(collect);
        }
        mapParam.put(CommonConstant.TEST_ITEM_ID, JSON.toJSONString(idList));
        List<Map> sourceProjectRelationList = tbMapRelationService.getMapRelation(CommonConstant.TEST_ITEM_ENUM, null,null,mapParam, Map.class);
        Map<String, List<Map>> enumList = sourceProjectRelationList.stream().collect(Collectors.groupingBy(x->String.valueOf(x.get(CommonConstant.TEST_ITEM_ID))));
        for (TestItemsForm testItemsForm : result) {
            testItemsForm.setAssemblyContentName(map.get(testItemsForm.getId()));
            if(testItemsForm.getItemType()==0){
                testItemsForm.setEnumList(enumList.get(CommonConstant.ZERO));
            }else {
                testItemsForm.setEnumList(enumList.get(String.valueOf(testItemsForm.getId())));
            }
        }
        }catch (MyException e){
            throw e;
        }catch (Exception e){
            log.error("sourceProjectRelationList翻译枚举失败",e);
        }
        return  result;

    }
    @Override
    public TestItemsForm insert(TestItemsForm testItemsForm) {
        Date currentDate = DateUtil.getCurrentDate();
        //添加检测项目
        testItemsForm.setCreateTime(currentDate);
        testItemsForm.setUpdateTime(currentDate);
        tbTestItemsMapper.insertSelective(testItemsForm);
        if(testItemsForm.getItemType()!=0){
            List<TbMapRelation> list=new ArrayList<>();
            for (ItemEnumPoJo itemEnumPoJo : testItemsForm.getItemEnumPoJoList()) {
                TbMapRelation mapRelation=new TbMapRelation();
                mapRelation.setConfigType(CommonConstant.TEST_ITEM_ENUM);
                mapRelation.setLevel1(testItemsForm.getConfigKey());
                mapRelation.setLevel2(String.valueOf(testItemsForm.getId()));
                mapRelation.setLevel3(String.valueOf(testItemsForm.getItemType()));
                mapRelation.setLevel4(itemEnumPoJo.getEnumKey());
                mapRelation.setLevel5(itemEnumPoJo.getEnumValue());
                mapRelation.setLevel6(itemEnumPoJo.getEnumFlag());
                mapRelation.setPosition(itemEnumPoJo.getPosition()==null?0:itemEnumPoJo.getPosition());
                mapRelation.setCreateTime(currentDate);
                mapRelation.setUpdateTime(currentDate);
                list.add(mapRelation);
            }
            tbMapRelationService.batchInsert(list);
        }
        //返显
        //将枚举填入
        Map<String,String> mapParam=new HashMap<>(2);
        if(testItemsForm.getItemType()==0){
            mapParam.put(CommonConstant.CONFIG_KEY,CommonConstant.DEFAULT);
        }else {
            mapParam.put(CommonConstant.TEST_ITEM_ID,String.valueOf(testItemsForm.getId()));
        }
        try {
            List<Map> sourceProjectRelationList = tbMapRelationService.getMapRelation(CommonConstant.TEST_ITEM_ENUM, mapParam,null,null, Map.class);
            testItemsForm.setEnumList(sourceProjectRelationList);
        }catch (MyException e){
            throw e;
        }catch (Exception e){
            log.error("sourceProjectRelation翻译枚举失败",e);
        }
        return testItemsForm;
    }

    @Override
    public TestItemsForm insert(TbTestItems tbTestItems, List<TbMapRelation> tbMapRelationList) {
        Date currentDate = DateUtil.getCurrentDate();
        //添加检测项目
        tbTestItems.setCreateTime(currentDate);
        tbTestItems.setUpdateTime(currentDate);
        tbTestItemsMapper.insertSelective(tbTestItems);
        TestItemsForm testItemsForm = convert.tbTestItemsToForm(tbTestItems);
        if(CollectionUtils.isEmpty(tbMapRelationList)){
            return testItemsForm;
        }
        tbMapRelationList.forEach(x->{
            x.setLevel2(String.valueOf(tbTestItems.getId()));
            x.setLevel1(tbTestItems.getConfigKey());
            x.setLevel3(String.valueOf(tbTestItems.getItemType()));
        });
        tbMapRelationService.batchInsert(tbMapRelationList);
        //TODO 没有翻译枚举  需要时候再添加
        return testItemsForm;
    }

    @Override
    public TestItemsForm updateById(TestItemsForm testItemsForm) {
        Date currentDate = DateUtil.getCurrentDate();
        testItemsForm.setUpdateTime(currentDate);
        tbTestItemsMapper.updateByPrimaryKeySelective(testItemsForm);
        //修改mapRelation
        if(CollectionUtils.isEmpty(testItemsForm.getItemEnumPoJoList())){
            return testItemsForm;
        }
        if(testItemsForm.getItemType()!=0){
            List<TbMapRelation> list=new ArrayList<>();
            for (ItemEnumPoJo itemEnumPoJo : testItemsForm.getItemEnumPoJoList()) {
                TbMapRelation mapRelation=new TbMapRelation();
                mapRelation.setConfigType(CommonConstant.TEST_ITEM_ENUM);
                mapRelation.setLevel1(testItemsForm.getConfigKey());
                mapRelation.setLevel2(String.valueOf(testItemsForm.getId()));
                mapRelation.setLevel3(String.valueOf(testItemsForm.getItemType()));
                mapRelation.setLevel4(itemEnumPoJo.getEnumKey());
                mapRelation.setLevel5(itemEnumPoJo.getEnumValue());
                mapRelation.setLevel6(itemEnumPoJo.getEnumFlag());
                mapRelation.setPosition(itemEnumPoJo.getPosition()==null?0:itemEnumPoJo.getPosition());
                mapRelation.setUpdateTime(currentDate);
                mapRelation.setCreateTime(currentDate);
                list.add(mapRelation);
            }
            TbMapRelation updateMap=new TbMapRelation();
            updateMap.setConfigType(CommonConstant.TEST_ITEM_ENUM);
            updateMap.setLevel2(String.valueOf(testItemsForm.getId()));
            tbMapRelationService.delAndBatchInsert(updateMap,list);

        }
        //返显
        //将枚举填入
        Map<String,String> mapParam=new HashMap<>(2);
        if(testItemsForm.getItemType()==0){
            mapParam.put(CommonConstant.CONFIG_KEY,CommonConstant.DEFAULT);
        }else {
            mapParam.put(CommonConstant.TEST_ITEM_ID,String.valueOf(testItemsForm.getId()));
        }
        try {
            List<Map> sourceProjectRelationList = tbMapRelationService.getMapRelation(CommonConstant.TEST_ITEM_ENUM, mapParam,null,null, Map.class);
            testItemsForm.setEnumList(sourceProjectRelationList);
        }catch (MyException e){
            throw e;
        }catch (Exception e){
            log.error("updateId,sourceProjectRelation翻译枚举失败",e);
        }
        return testItemsForm;
    }

    @Override
    public void deleteById(Long id) {
        //校验id下有没有对应的checkInfo
        TbCheckInfoDetail detail=new TbCheckInfoDetail();
        detail.setTestItemsId(id);
        List<TbCheckInfoDetail> tbCheckInfoDetails = tbCheckInfoService.selectDetail(detail);
        if(!CollectionUtils.isEmpty(tbCheckInfoDetails)){
            throw new MyException(500,"您删除的检测项目已经有对应的设备录入,不可删除");
        }
        tbTestItemsMapper.deleteByPrimaryKey(id);
        TbMapRelation updateMap=new TbMapRelation();
        updateMap.setConfigType(CommonConstant.TEST_ITEM_ENUM);
        updateMap.setLevel2(String.valueOf(id));
        tbMapRelationService.delAndBatchInsert(updateMap,null);
    }
}
