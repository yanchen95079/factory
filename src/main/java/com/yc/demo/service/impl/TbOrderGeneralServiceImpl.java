package com.yc.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.OrderGeneralDetailPojo;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import com.yc.demo.domain.ex.TbOrderGeneralSelectPage;
import com.yc.demo.mapper.TbOrderGeneralMapper;
import com.yc.demo.service.TbDefinitionStateFlowService;
import com.yc.demo.service.TbMapRelationService;
import com.yc.demo.service.TbOrderGeneralService;
import com.yc.demo.service.TbStatusFlowRecordService;
import com.yc.demo.support.FlowNode;
import com.yc.demo.support.OrderGeneralSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * date 2021/5/29 20:38
 */
@Slf4j
@Service
@Transactional(rollbackFor = Throwable.class)
public class TbOrderGeneralServiceImpl implements TbOrderGeneralService {
    @Autowired
    private TbOrderGeneralMapper tbOrderGeneralMapper;
    @Autowired
    private TbDefinitionStateFlowService tbDefinitionStateFlowService;
    @Autowired
    private OrderGeneralSupport orderGeneralSupport;
    @Autowired
    private TbStatusFlowRecordService tbStatusFlowRecordService;
    @Autowired
    private TbMapRelationService tbMapRelationService;
    @Override
    public void insert(OrderGeneralPojo orderGeneralPojo,boolean next) {
        //查询传入的group_uuid没有自己生成一个
        if(StringUtils.isEmpty(orderGeneralPojo.getGroupUuid())){
            orderGeneralPojo.setGroupUuid(UUID.randomUUID().toString().replaceAll("-",""));
        }
        //找到这个权限下所有的工作流流程
        TbDefinitionStateFlow flow=new TbDefinitionStateFlow();
        flow.setDefType(orderGeneralPojo.getDefType());
        List<TbDefinitionStateFlow> tbDefinitionStateFlows = tbDefinitionStateFlowService.selectOrderByPosition(flow);
        if(CollectionUtils.isEmpty(tbDefinitionStateFlows)){
            throw new MyException(500,"没有对应的工作流流程");
        }
        //判断当前人是否有第一个流程权限
        List<TbAcl> aclList = orderGeneralPojo.getUser().getAclList();
        if(CollectionUtils.isEmpty(aclList)){
            throw new MyException(500,"该用户没有任何权限操作");
        }
        // 是就新建总表OrderGeneral
        orderGeneralPojo.setState(0);
        FlowNode flowNode = getFlowNode(orderGeneralPojo,tbDefinitionStateFlows, null);
        if(flowNode.getAclCode()==null||!aclList.stream().anyMatch(x -> x.getAclCode().equals(flowNode.getAclCode()))){
            throw new MyException(500,"该用户没有权限操作");
        }
        if(next){
            //上一个acl为当前的 当前acl和user为工作流转到的（下一个 下一个user为空） 下一个为下一个的下一个不记录先
            orderGeneralPojo.setBeforeAclCode(flowNode.getAclCode());
            orderGeneralPojo.setBeforeUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
            if(flowNode.getNext()==null){
                orderGeneralPojo.setState(1);
                orderGeneralPojo.setNowUserCode("");
                orderGeneralPojo.setNowAclCode("");
                orderGeneralPojo.setNextAclCode("");
                orderGeneralPojo.setNextUserCode("");
            }else {
                orderGeneralPojo.setNowUserCode("");
                orderGeneralPojo.setNowAclCode(flowNode.getNext().getAclCode());
                orderGeneralPojo.setNextAclCode("");
                orderGeneralPojo.setNextUserCode("");
            }

        }else {
            if(flowNode.getAclCode()==null){
                orderGeneralPojo.setState(1);
                orderGeneralPojo.setNowUserCode("");
                orderGeneralPojo.setNowAclCode("");
                orderGeneralPojo.setNextUserCode("");
                orderGeneralPojo.setNextAclCode("");
            }else {
                //上一个acl空 当前acl和user为当前 下一个先不记录
                orderGeneralPojo.setBeforeAclCode("");
                orderGeneralPojo.setBeforeUserCode("");
                orderGeneralPojo.setNowAclCode(flowNode.getAclCode());
                orderGeneralPojo.setNowUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
                orderGeneralPojo.setNextAclCode("");
                orderGeneralPojo.setNextUserCode("");
            }
        }
        //新建对应的子业务的数据
        orderGeneralSupport.insetOrder(orderGeneralPojo);
        //新建所有的工作流流程 注意第一个工作流需要添加操作人和操作时间和操作内容
        List<TbStatusFlowRecord> list=new ArrayList<>();
        for (int i = 0; i < tbDefinitionStateFlows.size(); i++) {
            TbStatusFlowRecord record=new TbStatusFlowRecord();
            record.setDefType(orderGeneralPojo.getDefType());
            record.setAclCode(tbDefinitionStateFlows.get(i).getAclCode());
            record.setEnable(1);
            record.setGroupId(orderGeneralPojo.getGroupUuid());
            record.setCreateTime(new Date());
            if(i==0){
                record.setContent(orderGeneralPojo.getWorkContent());
                record.setUpdateTime(new Date());
                record.setWorkUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
                record.setWorkUserName(orderGeneralPojo.getUser().getUserName());
            }else {
                record.setWorkUserCode("");
                record.setWorkUserName("");
            }
            list.add(record);
        }
        tbStatusFlowRecordService.batchInsert(list);
    }

    /**
     * 得到某个权限这个流的当前流node
     * @param orderGeneralPojo 入参
     * @param tbDefinitionStateFlows
     * @param aclCode
     * @return
     */
    private FlowNode getFlowNode(OrderGeneralPojo orderGeneralPojo,List<TbDefinitionStateFlow> tbDefinitionStateFlows, String aclCode) {
        //找到这个单子所有特殊的配置
        Map<String,String> mapParam=new HashMap<>(2);
        mapParam.put(CommonConstant.FLOW_TYPE,String.valueOf(orderGeneralPojo.getDefType()));
        List<Map> sourceProjectRelationList =new ArrayList<>();
        try {
            sourceProjectRelationList = tbMapRelationService.getMapRelation(CommonConstant.STATE_FLOW_RULE, mapParam,null,null, Map.class);
        } catch (Exception e) {
            log.error("TbOrderGeneralServiceImpl getMapRelation error");
        }
        List<FlowNode> nodeList = FlowNode.getNodeList(sourceProjectRelationList,orderGeneralPojo,tbDefinitionStateFlows, true);
        if(aclCode==null){
            return nodeList.get(0);
        }
        List<FlowNode> collect = nodeList.stream().filter(x -> x.getAclCode().equals(aclCode)).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(collect)){
            return new FlowNode();
        }
        return collect.get(0);
    }

    @Override
    public void nextStep(OrderGeneralPojo orderGeneralPojo) {
        //查询groupuuid是否有对应的单子 没有直接insert(true) return
        if(StringUtils.isEmpty(orderGeneralPojo.getGroupUuid())){
            this.insert(orderGeneralPojo,true);
            return;
        }
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(orderGeneralPojo.getGroupUuid());
        List<TbOrderGeneral> tbOrderGeneralList = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(tbOrderGeneralList)){
            this.insert(orderGeneralPojo,true);
            return;
        }
        TbOrderGeneral tbOrderGeneralOld= tbOrderGeneralList.get(0);
        //有的话判断当前人是否和general当前人一样 不一样不可以处理
        if(!String.valueOf(orderGeneralPojo.getUser().getUserCode()).equals(tbOrderGeneralOld.getNowUserCode())){
            throw new MyException(500,"当前单子并非您受理,请刷新页面验证");
        }
        //update对应的工作流log
        TbStatusFlowRecord record=new TbStatusFlowRecord();
        record.setGroupId(tbOrderGeneralOld.getGroupUuid());
        record.setDefType(tbOrderGeneralOld.getDefType());
        record.setAclCode(tbOrderGeneralOld.getNowAclCode());
        record.setUpdateTime(new Date());
        record.setWorkUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        record.setWorkUserName(orderGeneralPojo.getUser().getUserName());
        record.setContent(orderGeneralPojo.getWorkContent());
        tbStatusFlowRecordService.updateByGroupIdAndTypeAndAcl(record);

        //找到这个权限下所有的工作流流程
        TbDefinitionStateFlow flow=new TbDefinitionStateFlow();
        flow.setDefType(tbOrderGeneralOld.getDefType());
        List<TbDefinitionStateFlow> tbDefinitionStateFlows = tbDefinitionStateFlowService.selectOrderByPosition(flow);
        FlowNode flowNode = getFlowNode(orderGeneralPojo,tbDefinitionStateFlows, tbOrderGeneralOld.getNowAclCode());
        //上一个acl为当前的 当前acl和user为工作流转到的（下一个 下一个user为空） 下一个为下一个的下一个 如果到了尾部 需要修改general表为完成
        orderGeneralPojo.setBeforeAclCode(flowNode.getAclCode());
        orderGeneralPojo.setBeforeUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        if(flowNode.getNext()!=null){
            orderGeneralPojo.setNowAclCode(flowNode.getNext().getAclCode());
        }else {
            orderGeneralPojo.setState(1);
            orderGeneralPojo.setNowAclCode("");
        }
        orderGeneralPojo.setNowUserCode("");
        orderGeneralPojo.setNextAclCode("");
        orderGeneralPojo.setNextUserCode("");
        orderGeneralPojo.setId(tbOrderGeneralOld.getId());
        orderGeneralSupport.updateOrder(true,orderGeneralPojo);
    }

    @Override
    public void backStep(OrderGeneralPojo orderGeneralPojo) {
        //查询groupuuid 如果没有抛出异常 没有查到单子
        if(StringUtils.isEmpty(orderGeneralPojo.getGroupUuid())){
            throw new MyException(500,"groupUuid不可为空");
        }
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(orderGeneralPojo.getGroupUuid());
        List<TbOrderGeneral> tbOrderGeneralList = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(tbOrderGeneralList)){
            throw new MyException(500,"没有搜到对应单子");
        }
        TbOrderGeneral tbOrderGeneralOld= tbOrderGeneralList.get(0);
        if(StringUtils.isEmpty(tbOrderGeneralOld.getNowUserCode())){
            throw new MyException(500,"此单据没有被受理,无法后退");
        }
        if(!String.valueOf(orderGeneralPojo.getUser().getUserCode()).equals(tbOrderGeneralOld.getNowUserCode())){
            throw new MyException(500,"当前单子并非您受理,请刷新页面验证");
        }
        //update对应的工作流log
        TbStatusFlowRecord record=new TbStatusFlowRecord();
        record.setGroupId(tbOrderGeneralOld.getGroupUuid());
        record.setDefType(tbOrderGeneralOld.getDefType());
        record.setAclCode(tbOrderGeneralOld.getNowAclCode());
        record.setUpdateTime(new Date());
        record.setWorkUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        record.setWorkUserName(orderGeneralPojo.getUser().getUserName());
        record.setContent(orderGeneralPojo.getWorkContent());
        tbStatusFlowRecordService.updateByGroupIdAndTypeAndAcl(record);
        //找到这个权限下所有的工作流流程
        TbDefinitionStateFlow flow=new TbDefinitionStateFlow();
        flow.setDefType(tbOrderGeneralOld.getDefType());
        List<TbDefinitionStateFlow> tbDefinitionStateFlows = tbDefinitionStateFlowService.selectOrderByPosition(flow);
        FlowNode flowNode = getFlowNode(orderGeneralPojo,tbDefinitionStateFlows, tbOrderGeneralOld.getNowAclCode());
        //上一个acl为上一个的上一个 当前acl和user为工作流转到的（上一个 user赋值空按照角色划分） 下一个为当前这个
        if(flowNode.getPrex()==null){
            throw new MyException(500,"没有上一步工作流");
        }else {
            orderGeneralPojo.setBeforeAclCode("");
            orderGeneralPojo.setBeforeUserCode("");
            orderGeneralPojo.setNowAclCode(flowNode.getPrex().getAclCode());
            orderGeneralPojo.setNowUserCode("");
            orderGeneralPojo.setNextAclCode(flowNode.getAclCode());
            orderGeneralPojo.setNextUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        }
        orderGeneralPojo.setId(tbOrderGeneralOld.getId());
        orderGeneralSupport.updateOrder(true,orderGeneralPojo);
    }

    @Override
    public void saveStep(OrderGeneralPojo orderGeneralPojo) {
        //查询groupuuid是否有对应的单子 没有直接insert(false) return
        if(StringUtils.isEmpty(orderGeneralPojo.getGroupUuid())){
            this.insert(orderGeneralPojo,false);
            return;
        }
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(orderGeneralPojo.getGroupUuid());
        List<TbOrderGeneral> tbOrderGeneralList = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(tbOrderGeneralList)){
            this.insert(orderGeneralPojo,false);
            return;
        }
        TbOrderGeneral tbOrderGeneralOld= tbOrderGeneralList.get(0);
        //有的话判断当前人是否和general当前人一样 不一样不可以处理
        if(!String.valueOf(orderGeneralPojo.getUser().getUserCode()).equals(tbOrderGeneralOld.getNowUserCode())){
            throw new MyException(500,"当前单子并非您受理,请刷新页面验证");
        }
        //update对应的工作流log
        TbStatusFlowRecord record=new TbStatusFlowRecord();
        record.setGroupId(tbOrderGeneralOld.getGroupUuid());
        record.setDefType(tbOrderGeneralOld.getDefType());
        record.setAclCode(tbOrderGeneralOld.getNowAclCode());
        record.setUpdateTime(new Date());
        record.setWorkUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        record.setWorkUserName(orderGeneralPojo.getUser().getUserName());
        record.setContent(orderGeneralPojo.getWorkContent());
        tbStatusFlowRecordService.updateByGroupIdAndTypeAndAcl(record);
        // update对应的子业务的数据
        orderGeneralSupport.updateOrder(false,orderGeneralPojo);
    }

    @Override
    public void acceptance(OrderGeneralPojo orderGeneralPojo) {
        //查询groupuuid 如果没有抛出异常 没有查到单子
        if(StringUtils.isEmpty(orderGeneralPojo.getGroupUuid())){
            throw new MyException(500,"groupUuid不可为空");
        }
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(orderGeneralPojo.getGroupUuid());
        List<TbOrderGeneral> tbOrderGeneralList = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(tbOrderGeneralList)){
            throw new MyException(500,"没有搜到对应单子");
        }
        TbOrderGeneral tbOrderGeneralOld= tbOrderGeneralList.get(0);
        //查询当前的单子 是否当前人为空 如果不是提示已经有人受理了
        if(StringUtils.isNotEmpty(tbOrderGeneralOld.getNowUserCode())){
            throw new MyException(500,"当前单子已经有人受理了");
        }
        //查询当前单子当前权限和传入人的权限是否一致 如果不一致返回您没有权限受理
        boolean oneAcl = orderGeneralPojo.getUser().getAclList().stream().anyMatch(x -> x.getAclCode().equals(tbOrderGeneralOld.getNowAclCode()));
        if(!oneAcl){
            throw new MyException(500,"该用户没有权限操作,无法受理");
        }
        //更改general表的当前处理人
        orderGeneralPojo.setNowUserCode(String.valueOf(orderGeneralPojo.getUser().getUserCode()));
        orderGeneralPojo.setId(tbOrderGeneralOld.getId());
        orderGeneralSupport.updateOrder(true,orderGeneralPojo);
    }


    @Override
    public void deleteByGroupUuid(String groupUuid) {
        //根据id删除单子,并且根据group把对应的子业务和工作流log都删除
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(groupUuid);
        List<TbOrderGeneral> select = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(select)){
            return;
        }
        if(select.size()>1){
            throw new MyException(500,"groupUuid重复无法删除");
        }
        orderGeneralSupport.delOrder(select.get(0).getId(),select.get(0).getDefType(),select.get(0).getGroupUuid());
    }

    @Override
    public List<TbOrderGeneral> select(TbOrderGeneral tbOrderGeneral) {
        TbOrderGeneralExample example=new TbOrderGeneralExample();
        TbOrderGeneralExample.Criteria criteria = example.createCriteria();
        if(tbOrderGeneral.getState()!=null){
            criteria.andStateEqualTo(tbOrderGeneral.getState());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneral.getGroupUuid())){
            criteria.andGroupUuidEqualTo(tbOrderGeneral.getGroupUuid());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneral.getNowUserCode())){
            criteria.andNowUserCodeEqualTo(tbOrderGeneral.getNowUserCode());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneral.getNowAclCode())){
            criteria.andNowAclCodeEqualTo(tbOrderGeneral.getNowAclCode());
        }
        if(tbOrderGeneral.getCreateUser()!=null){
            criteria.andCreateUserEqualTo(tbOrderGeneral.getCreateUser());
        }
        return tbOrderGeneralMapper.selectByExample(example);
    }

    @Override
    public PageInfo<TbOrderGeneral> selectPage(TbOrderGeneralSelectPage tbOrderGeneralSelectPage) {
        //查找所有单子 按照当前人为自己的排在前面 然后是当前人为空的 然后是时间
        TbOrderGeneralExample example=new TbOrderGeneralExample();
        TbOrderGeneralExample.Criteria criteria = example.createCriteria();
        if(tbOrderGeneralSelectPage.getDefType()!=null){
            criteria.andDefTypeEqualTo(tbOrderGeneralSelectPage.getDefType());
        }
        if(tbOrderGeneralSelectPage.getState()!=null){
            criteria.andStateEqualTo(tbOrderGeneralSelectPage.getState());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneralSelectPage.getGroupUuid())){
            criteria.andGroupUuidEqualTo(tbOrderGeneralSelectPage.getGroupUuid());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneralSelectPage.getNowUserCode())){
            criteria.andNowUserCodeEqualTo(tbOrderGeneralSelectPage.getNowUserCode());
        }
        if(StringUtils.isNotEmpty(tbOrderGeneralSelectPage.getNowAclCode())){
            criteria.andNowAclCodeEqualTo(tbOrderGeneralSelectPage.getNowAclCode());
        }
        if(tbOrderGeneralSelectPage.getCreateUser()!=null){
            criteria.andCreateUserEqualTo(tbOrderGeneralSelectPage.getCreateUser());
        }
        if(tbOrderGeneralSelectPage.getCreateTimeStart()!=null && tbOrderGeneralSelectPage.getCreateTimeEnd()!=null){
            criteria.andCreateTimeBetween(tbOrderGeneralSelectPage.getCreateTimeStart(),tbOrderGeneralSelectPage.getCreateTimeEnd());
        }
        if(tbOrderGeneralSelectPage.getUser()!=null){
            if(tbOrderGeneralSelectPage.getAllDateFlag()!=null&&tbOrderGeneralSelectPage.getAllDateFlag()){
                example.setOrderByClause("id desc");
            }else {
                if(CollectionUtils.isEmpty(tbOrderGeneralSelectPage.getUser().getAclList())){
                    return null;
                }
                criteria.andNowAclCodeIn(tbOrderGeneralSelectPage.getUser().getAclList().stream().map(TbAcl::getAclCode).collect(Collectors.toList()));
                example.setOrderByClause("CASE now_user_code\n" +
                        "      WHEN "+tbOrderGeneralSelectPage.getUser().getUserCode()+" THEN 1\n" +
                        "      WHEN '' THEN 2\n" +
                        "      ELSE 3\n" +
                        "      END\n" +
                        "asc\n" +
                        ",id desc");
            }

        }

        PageHelper.startPage(tbOrderGeneralSelectPage.getOffset(), tbOrderGeneralSelectPage.getLimit());
        List<TbOrderGeneral> tbOrderGenerals = tbOrderGeneralMapper.selectByExample(example);
        return new PageInfo<>(tbOrderGenerals);
    }

    @Override
    public OrderGeneralDetailPojo selectDetailByGroupUuid(String groupUuid) {
        TbOrderGeneral tbOrderGeneral=new TbOrderGeneral();
        tbOrderGeneral.setGroupUuid(groupUuid);
        List<TbOrderGeneral> tbOrderGeneralList = this.select(tbOrderGeneral);
        if(CollectionUtils.isEmpty(tbOrderGeneralList)){
            throw new MyException(500,"没有找到对应单子");
        }
        TbOrderGeneral tbOrderGeneralOld= tbOrderGeneralList.get(0);
        return orderGeneralSupport.select(tbOrderGeneralOld.getDefType(),groupUuid);
    }
}
