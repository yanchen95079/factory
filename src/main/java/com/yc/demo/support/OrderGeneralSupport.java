package com.yc.demo.support;

import com.yc.demo.commom.enums.DefTypeEnum;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.OrderGeneralDetailPojo;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import com.yc.demo.mapper.*;
import com.yc.demo.service.TbStatusFlowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private TbOrderWarehouseLocationTransferNcmMapper tbOrderWarehouseLocationTransferNcmMapper;
    @Autowired
    private TbOrderWarehousingMapper tbOrderWarehousingMapper;
    @Autowired
    private TbStatusFlowRecordService tbStatusFlowRecordService;
    @Transactional(rollbackFor = Throwable.class)
    public void insetOrder(OrderGeneralPojo orderGeneralPojo){
        orderGeneralPojo.setCreateTime(new Date());
        //新增总表
        tbOrderGeneralMapper.insert(orderGeneralPojo);
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表新增
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            for (TbOrderProductionSupple tbOrderProductionSupple : orderGeneralPojo.getTbOrderProductionSupples()) {
                tbOrderProductionSupple.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderProductionSuppleMapper.batchInsert(orderGeneralPojo.getTbOrderProductionSupples());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            for (TbOrderExchange tbOrderExchange : orderGeneralPojo.getTbOrderExchanges()) {
                tbOrderExchange.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderExchangeMapper.batchInsert(orderGeneralPojo.getTbOrderExchanges());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            for (TbOrderWarehousing tbOrderWarehousing : orderGeneralPojo.getTbOrderWarehousings()) {
                tbOrderWarehousing.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderWarehousingMapper.batchInsert(orderGeneralPojo.getTbOrderWarehousings());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            for (TbOrderWarehouseLocationTransfer tbOrderWarehouseLocationTransfer : orderGeneralPojo.getTbOrderWarehouseLocationTransfers()) {
                tbOrderWarehouseLocationTransfer.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderWarehouseLocationTransferMapper.batchInsert(orderGeneralPojo.getTbOrderWarehouseLocationTransfers());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            for (TbOrderShortage tbOrderShortage : orderGeneralPojo.getTbOrderShortages()) {
                tbOrderShortage.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderShortageMapper.batchInsert(orderGeneralPojo.getTbOrderShortages());
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_6.getCode())){
            for (TbOrderWarehouseLocationTransferNcm tbOrderWarehouseLocationTransferNcm : orderGeneralPojo.getTbOrderWarehouseLocationTransferNcms()) {
                tbOrderWarehouseLocationTransferNcm.setGroupUuid(orderGeneralPojo.getGroupUuid());
            }
            tbOrderWarehouseLocationTransferNcmMapper.batchInsert(orderGeneralPojo.getTbOrderWarehouseLocationTransferNcms());
        }
    }

    /**
     *
     * @param flag 是否更新总表
     * @param orderGeneralPojo
     */
    @Transactional(rollbackFor = Throwable.class)
    public void updateOrder(boolean flag,OrderGeneralPojo orderGeneralPojo){
        //更新总表
        if(flag){
            orderGeneralPojo.setUpdateTime(new Date());
            tbOrderGeneralMapper.updateByPrimaryKeySelective(orderGeneralPojo);
        }
        //根据com.yc.demo.commom.enums.DefTypeEnum 判断走哪张表update
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            TbOrderProductionSuppleExample example=new TbOrderProductionSuppleExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderProductionSupple> tbOrderProductionSupples = tbOrderProductionSuppleMapper.selectByExample(example);
            List<Long> ids = tbOrderProductionSupples.stream().map(TbOrderProductionSupple::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderProductionSupples())){
                return;
            }
            List<TbOrderProductionSupple> collect = orderGeneralPojo.getTbOrderProductionSupples().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderProductionSuppleMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderProductionSupple::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderProductionSuppleMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderProductionSupple> collectInsert = orderGeneralPojo.getTbOrderProductionSupples().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderProductionSuppleMapper.batchInsert(collectInsert);
            }
            return;
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            TbOrderExchangeExample example=new TbOrderExchangeExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderExchange> tbOrderExchanges = tbOrderExchangeMapper.selectByExample(example);
            List<Long> ids = tbOrderExchanges.stream().map(TbOrderExchange::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderExchanges())){
                return;
            }
            List<TbOrderExchange> collect = orderGeneralPojo.getTbOrderExchanges().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderExchangeMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderExchange::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderExchangeMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderExchange> collectInsert = orderGeneralPojo.getTbOrderExchanges().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderExchangeMapper.batchInsert(collectInsert);
            }
            return;
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            TbOrderWarehousingExample example=new TbOrderWarehousingExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderWarehousing> tbOrderWarehousings = tbOrderWarehousingMapper.selectByExample(example);
            List<Long> ids = tbOrderWarehousings.stream().map(TbOrderWarehousing::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderWarehousings())){
                return;
            }
            List<TbOrderWarehousing> collect = orderGeneralPojo.getTbOrderWarehousings().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderWarehousingMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderWarehousing::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderWarehousingMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderWarehousing> collectInsert = orderGeneralPojo.getTbOrderWarehousings().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderWarehousingMapper.batchInsert(collectInsert);
            }
            return;
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            TbOrderWarehouseLocationTransferExample example=new TbOrderWarehouseLocationTransferExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderWarehouseLocationTransfer> tbOrderWarehouseLocationTransfers = tbOrderWarehouseLocationTransferMapper.selectByExample(example);
            List<Long> ids = tbOrderWarehouseLocationTransfers.stream().map(TbOrderWarehouseLocationTransfer::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderWarehouseLocationTransfers())){
                return;
            }
            List<TbOrderWarehouseLocationTransfer> collect = orderGeneralPojo.getTbOrderWarehouseLocationTransfers().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderWarehouseLocationTransferMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderWarehouseLocationTransfer::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderWarehouseLocationTransferMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderWarehouseLocationTransfer> collectInsert = orderGeneralPojo.getTbOrderWarehouseLocationTransfers().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderWarehouseLocationTransferMapper.batchInsert(collectInsert);
            }
            return;
        }
        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            TbOrderShortageExample example=new TbOrderShortageExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderShortage> tbOrderShortages = tbOrderShortageMapper.selectByExample(example);
            List<Long> ids = tbOrderShortages.stream().map(TbOrderShortage::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderShortages())){
                return;
            }
            List<TbOrderShortage> collect = orderGeneralPojo.getTbOrderShortages().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderShortageMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderShortage::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderShortageMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderShortage> collectInsert = orderGeneralPojo.getTbOrderShortages().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderShortageMapper.batchInsert(collectInsert);
            }
            return;
        }

        if(orderGeneralPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_6.getCode())){
            TbOrderWarehouseLocationTransferNcmExample example=new TbOrderWarehouseLocationTransferNcmExample();
            example.createCriteria().andGroupUuidEqualTo(orderGeneralPojo.getGroupUuid());
            List<TbOrderWarehouseLocationTransferNcm> tbOrderWarehouseLocationTransferNcms = tbOrderWarehouseLocationTransferNcmMapper.selectByExample(example);
            List<Long> ids = tbOrderWarehouseLocationTransferNcms.stream().map(TbOrderWarehouseLocationTransferNcm::getId).collect(Collectors.toList());
            if(CollectionUtils.isEmpty(orderGeneralPojo.getTbOrderWarehouseLocationTransferNcms())){
                return;
            }
            List<TbOrderWarehouseLocationTransferNcm> collect = orderGeneralPojo.getTbOrderWarehouseLocationTransferNcms().stream().filter(x -> x.getId() != null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                tbOrderWarehouseLocationTransferNcmMapper.batchUpdate(collect);
            }
            List<Long> idsParam=collect.stream().map(TbOrderWarehouseLocationTransferNcm::getId).collect(Collectors.toList());
            List<Long> collectDel = ids.stream().filter(x -> !idsParam.contains(x)).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectDel)){
                for (Long id : collectDel) {
                    tbOrderWarehouseLocationTransferNcmMapper.deleteByPrimaryKey(id);
                }
            }
            List<TbOrderWarehouseLocationTransferNcm> collectInsert = orderGeneralPojo.getTbOrderWarehouseLocationTransferNcms().stream().filter(x -> x.getId() == null).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collectInsert)){
                collectInsert.forEach(x->x.setGroupUuid(orderGeneralPojo.getGroupUuid()));
                tbOrderWarehouseLocationTransferNcmMapper.batchInsert(collectInsert);
            }
            return;
        }
    }


    @Transactional(rollbackFor = Throwable.class)
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
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_6.getCode())){
            TbOrderWarehouseLocationTransferNcmExample example=new TbOrderWarehouseLocationTransferNcmExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            tbOrderWarehouseLocationTransferNcmMapper.deleteByExample(example);
        }
        //删除工作流的log
        tbStatusFlowRecordService.deleteByUuid(groupUuid);
    }
    public OrderGeneralDetailPojo select(Integer delType, String groupUuid){
        OrderGeneralDetailPojo pojo=new OrderGeneralDetailPojo();
        TbStatusFlowRecord record=new TbStatusFlowRecord();
        record.setGroupId(groupUuid);
        record.setDefType(delType);
        pojo.setLists(tbStatusFlowRecordService.select(record));
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            TbOrderProductionSuppleExample example=new TbOrderProductionSuppleExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderProductionSupples(tbOrderProductionSuppleMapper.selectByExample(example));
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            TbOrderExchangeExample example=new TbOrderExchangeExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderExchanges(tbOrderExchangeMapper.selectByExample(example));
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            TbOrderWarehousingExample example=new TbOrderWarehousingExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderWarehousings(tbOrderWarehousingMapper.selectByExample(example));
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            TbOrderWarehouseLocationTransferExample example=new TbOrderWarehouseLocationTransferExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderWarehouseLocationTransfers(tbOrderWarehouseLocationTransferMapper.selectByExample(example));
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            TbOrderShortageExample example=new TbOrderShortageExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderShortages(tbOrderShortageMapper.selectByExample(example));
        }
        if(delType.equals(DefTypeEnum.DEF_TYPE_ENUM_6.getCode())){
            TbOrderWarehouseLocationTransferNcmExample example=new TbOrderWarehouseLocationTransferNcmExample();
            example.createCriteria().andGroupUuidEqualTo(groupUuid);
            pojo.setTbOrderWarehouseLocationTransferNcms(tbOrderWarehouseLocationTransferNcmMapper.selectByExample(example));
        }
        return pojo;
    }

}
