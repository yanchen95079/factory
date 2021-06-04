package com.yc.demo.support;

import com.yc.demo.commom.enums.DefTypeEnum;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import com.yc.demo.mapper.*;
import com.yc.demo.service.TbStatusFlowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Yanchen
 * date 2021/5/29 20:36
 */
@Component
public class OrderGeneralSupport {
    @Autowired
    private TbOrderGeneralMapper tbOrderGeneralMapper;
    @Autowired
    private TbOrderProductionSuppleMapper tbOrderProductionSuppleMapper;
    @Autowired
    private TbOrderExchangeMapper tbOrderExchangeMapper;
    @Autowired
    private TbOrderShortageMapper tbOrderShortageMapper;
    @Autowired
    private TbOrderWarehouseLocationTransferMapper tbOrderWarehouseLocationTransferMapper;
    @Autowired
    private TbOrderWarehousingMapper tbOrderWarehousingMapper;
    @Autowired
    private TbStatusFlowRecordService tbStatusFlowRecordService;
    public void insetOrder(OrderGeneralPojo orderGeneralPojo){
        orderGeneralPojo.setCreateTime(new Date());
        //新增总表
        tbOrderGeneralMapper.insert(orderGeneralPojo);
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表新增
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            tbOrderProductionSuppleMapper.batchInsert(orderGeneralPojo.getTbOrderProductionSupples());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            tbOrderExchangeMapper.batchInsert(orderGeneralPojo.getTbOrderExchanges());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            tbOrderWarehousingMapper.batchInsert(orderGeneralPojo.getTbOrderWarehousings());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            tbOrderWarehouseLocationTransferMapper.batchInsert(orderGeneralPojo.getTbOrderWarehouseLocationTransfers());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            tbOrderShortageMapper.batchInsert(orderGeneralPojo.getTbOrderShortages());
        }
    }

    /**
     *
     * @param flag 是否更新总表
     * @param orderGeneralPojo
     */
    public void updateOrder(boolean flag,OrderGeneralPojo orderGeneralPojo){
        //更新总表
        if(flag){
            orderGeneralPojo.setUpdateTime(new Date());
            tbOrderGeneralMapper.updateByPrimaryKey(orderGeneralPojo);
        }
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表update
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            tbOrderProductionSuppleMapper.batchUpdate(orderGeneralPojo.getTbOrderProductionSupples());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            tbOrderExchangeMapper.batchUpdate(orderGeneralPojo.getTbOrderExchanges());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            tbOrderWarehousingMapper.batchUpdate(orderGeneralPojo.getTbOrderWarehousings());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            tbOrderWarehouseLocationTransferMapper.batchUpdate(orderGeneralPojo.getTbOrderWarehouseLocationTransfers());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            tbOrderShortageMapper.batchUpdate(orderGeneralPojo.getTbOrderShortages());
        }
    }



    public void delOrder(Long generalId,Integer delType,String groupUuid){
        //删除总表
        tbOrderGeneralMapper.deleteByPrimaryKey(generalId);
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表delete
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            TbOrderProductionSuppleExample example=new TbOrderProductionSuppleExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderProductionSuppleMapper.deleteByExample(example);
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            TbOrderExchangeExample example=new TbOrderExchangeExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderExchangeMapper.deleteByExample(example);
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            TbOrderWarehousingExample example=new TbOrderWarehousingExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderWarehousingMapper.deleteByExample(example);
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            TbOrderWarehouseLocationTransferExample example=new TbOrderWarehouseLocationTransferExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderWarehouseLocationTransferMapper.deleteByExample(example);
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            TbOrderShortageExample example=new TbOrderShortageExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderShortageMapper.deleteByExample(example);
        }
        //删除工作流的log
        tbStatusFlowRecordService.deleteByUuid(groupUuid);
    }


}
