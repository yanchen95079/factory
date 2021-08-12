package com.yc.demo.service.impl;

import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.commom.enums.DefTypeEnum;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.commom.utils.DateUtil;
import com.yc.demo.commom.utils.ExcelUtils;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.*;
import com.yc.demo.mapper.*;
import com.yc.demo.service.ExcelService;
import com.yc.demo.service.TbMapRelationService;
import com.yc.demo.service.TbOrderGeneralService;
import com.yc.demo.service.TbStatusFlowRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yanchen
 * date 2021/8/12 14:03
 */
@Service
@Transactional
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private TbMapRelationService tbMapRelationService;
    @Autowired
    private TbOrderGeneralService tbOrderGeneralService;
    @Autowired
    private TbStatusFlowRecordService tbStatusFlowRecordService;
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
    @Override
    public void materialNumberEnum(MultipartFile multipartFile) {
        List<MaterialNumberExcelPojo> materialNumberExcelPojos = ExcelUtils.importExcel(multipartFile, 0, 1, MaterialNumberExcelPojo.class);
        if(CollectionUtils.isEmpty(materialNumberExcelPojos)){
            throw new MyException(500,"数据不可为空");
        }
        TbMapRelation mapUpdate=new TbMapRelation();
        mapUpdate.setConfigType(CommonConstant.MATERIAL_NUMBER_ENUM);
        List<TbMapRelation> list=new ArrayList<>();
        for (MaterialNumberExcelPojo materialNumberExcelPojo : materialNumberExcelPojos) {
            TbMapRelation relation=new TbMapRelation();
            relation.setConfigType(CommonConstant.MATERIAL_NUMBER_ENUM);
            relation.setLevel1(materialNumberExcelPojo.getName());
            relation.setLevel2(materialNumberExcelPojo.getNumber());
            relation.setLevel3(materialNumberExcelPojo.getStandardCost());
            list.add(relation);
        }
        tbMapRelationService.delAndBatchInsert(mapUpdate,list);
    }

    @Override
    public void orderOutExcel(TbOrderGeneralExcelPojo tbOrderGeneralExcelPojo, HttpServletResponse res) throws Exception {
        String secondTitle =DateUtil.date2String(tbOrderGeneralExcelPojo.getCreateTimeStart(),DateUtil.DatePattern.YYYYMMDDHHmmss.getValue())+" ~ "+DateUtil.date2String(tbOrderGeneralExcelPojo.getCreateTimeEnd(),DateUtil.DatePattern.YYYYMMDDHHmmss.getValue());

        Map<String,String> mapParam=new HashMap<>(2);
        mapParam.put(CommonConstant.DEF_TYPE,String.valueOf(tbOrderGeneralExcelPojo.getDefType()));
        List<Map> sourceProjectRelationList = tbMapRelationService.getMapRelation(CommonConstant.EXCEL_OUT_FLOW_RECORD_CONFIG, mapParam,null,null, Map.class);

        TbStatusFlowRecordEx record=new TbStatusFlowRecordEx();
        record.setGroupUuidList(tbOrderGeneralExcelPojo.getGroupUuidList());
        List<TbStatusFlowRecord> tbStatusFlowRecords = tbStatusFlowRecordService.selectEx(record);
        Map<String, List<TbStatusFlowRecord>> collect = tbStatusFlowRecords.stream().collect(Collectors.groupingBy(TbStatusFlowRecord::getGroupId));
        //拿到所有需要在excel导出的流程数据
        List<Map> recordList=new ArrayList<>();
        if(!CollectionUtils.isEmpty(sourceProjectRelationList)){
            for (Map.Entry<String, List<TbStatusFlowRecord>> stringListEntry : collect.entrySet()) {
                Map<String,String> mapRecord=new HashMap<>(8);
                mapRecord.put(CommonConstant.GROUP_UUID,stringListEntry.getKey());
                for (TbStatusFlowRecord tbStatusFlowRecord : stringListEntry.getValue()) {
                    for (Map map : sourceProjectRelationList) {
                        if(tbStatusFlowRecord.getAclCode().equals(map.get(CommonConstant.ACL_CODE))){
                            if(map.get(CommonConstant.EXCEL_CODE1)!=null){
                                mapRecord.put(String.valueOf(map.get(CommonConstant.EXCEL_CODE1)),tbStatusFlowRecord.getWorkUserName());
                            }
                            if(map.get(CommonConstant.EXCEL_CODE2)!=null){
                                mapRecord.put(String.valueOf(map.get(CommonConstant.EXCEL_CODE2)),tbStatusFlowRecord.getContentRemrk());
                            }
                            if(map.get(CommonConstant.EXCEL_CODE3)!=null){
                                mapRecord.put(String.valueOf(map.get(CommonConstant.EXCEL_CODE3)),DateUtil.date2String(tbStatusFlowRecord.getUpdateTime(),DateUtil.DatePattern.YYYYMMDDHHmmss.getValue()));
                            }
                        }
                    }
                }
                recordList.add(mapRecord);
            }
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_1.getCode())){
            TbOrderProductionSuppleExample example=new TbOrderProductionSuppleExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderProductionSupple> tbOrderProductionSupples = tbOrderProductionSuppleMapper.selectByExample(example);
            List<OrderProductionSuppleExcelPojo>  list=new ArrayList<>();
            for (TbOrderProductionSupple tbOrderProductionSupple : tbOrderProductionSupples) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderProductionSupple.getGroupUuid())).collect(Collectors.toList());
                OrderProductionSuppleExcelPojo pojo=(OrderProductionSuppleExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderProductionSuppleExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderProductionSupple,pojo);
                list.add(pojo);
            }
             ExcelUtils.exportExcel(list,"生产补货单汇总", secondTitle,"生产补货单汇总",OrderProductionSuppleExcelPojo.class,"生产补货单汇总.xls",res);
             return;
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_2.getCode())){
            TbOrderExchangeExample example=new TbOrderExchangeExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderExchange> tbOrderExchanges = tbOrderExchangeMapper.selectByExample(example);
            List<OrderExchangeExcelPojo>  list=new ArrayList<>();
            for (TbOrderExchange tbOrderExchange : tbOrderExchanges) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderExchange.getGroupUuid())).collect(Collectors.toList());
                OrderExchangeExcelPojo pojo=(OrderExchangeExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderExchangeExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderExchange,pojo);
                list.add(pojo);
            }
            ExcelUtils.exportExcel(list,"换货单汇总", secondTitle,"换货单汇总",OrderExchangeExcelPojo.class,"换货单汇总.xls",res);
            return;
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_3.getCode())){
            TbOrderWarehousingExample example=new TbOrderWarehousingExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderWarehousing> tbOrderWarehousings = tbOrderWarehousingMapper.selectByExample(example);
            List<OrderWarehousingExcelPojo>  list=new ArrayList<>();
            for (TbOrderWarehousing tbOrderWarehousing : tbOrderWarehousings) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderWarehousing.getGroupUuid())).collect(Collectors.toList());
                OrderWarehousingExcelPojo pojo=(OrderWarehousingExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderWarehousingExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderWarehousing,pojo);
                list.add(pojo);
            }
            ExcelUtils.exportExcel(list,"成品入库单汇总", secondTitle,"成品入库单汇总",OrderWarehousingExcelPojo.class,"成品入库单汇总.xls",res);
            return;
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_4.getCode())){
            TbOrderWarehouseLocationTransferExample example=new TbOrderWarehouseLocationTransferExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderWarehouseLocationTransfer> tbOrderWarehouseLocationTransfers = tbOrderWarehouseLocationTransferMapper.selectByExample(example);
            List<OrderWarehouseLocationTransferExcelPojo>  list=new ArrayList<>();
            for (TbOrderWarehouseLocationTransfer tbOrderWarehouseLocationTransfer : tbOrderWarehouseLocationTransfers) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderWarehouseLocationTransfer.getGroupUuid())).collect(Collectors.toList());
                OrderWarehouseLocationTransferExcelPojo pojo=(OrderWarehouseLocationTransferExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderWarehouseLocationTransferExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderWarehouseLocationTransfer,pojo);
                list.add(pojo);
            }
            ExcelUtils.exportExcel(list,"库位转移单汇总", secondTitle,"库位转移单汇总",OrderWarehouseLocationTransferExcelPojo.class,"库位转移单汇总.xls",res);
            return;
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_5.getCode())){
            TbOrderShortageExample example=new TbOrderShortageExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderShortage> tbOrderShortages = tbOrderShortageMapper.selectByExample(example);
            List<OrderShortageExcelPojo>  list=new ArrayList<>();
            for (TbOrderShortage tbOrderShortage : tbOrderShortages) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderShortage.getGroupUuid())).collect(Collectors.toList());
                OrderShortageExcelPojo pojo=(OrderShortageExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderShortageExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderShortage,pojo);
                list.add(pojo);
            }
            ExcelUtils.exportExcel(list,"短缺报告汇总", secondTitle,"短缺报告汇总",OrderShortageExcelPojo.class,"短缺报告汇总.xls",res);
            return;
        }
        if(tbOrderGeneralExcelPojo.getDefType().equals(DefTypeEnum.DEF_TYPE_ENUM_6.getCode())){
            TbOrderWarehouseLocationTransferNcmExample example=new TbOrderWarehouseLocationTransferNcmExample();
            example.createCriteria().andGroupUuidIn(tbOrderGeneralExcelPojo.getGroupUuidList());
            List<TbOrderWarehouseLocationTransferNcm> tbOrderWarehouseLocationTransferNcms = tbOrderWarehouseLocationTransferNcmMapper.selectByExample(example);
            List<OrderWarehouseLocationTransferNcmExcelPojo>  list=new ArrayList<>();
            for (TbOrderWarehouseLocationTransferNcm tbOrderWarehouseLocationTransferNcm : tbOrderWarehouseLocationTransferNcms) {
                List<Map> records = recordList.stream().filter(x -> x.get(CommonConstant.GROUP_UUID).equals(tbOrderWarehouseLocationTransferNcm.getGroupUuid())).collect(Collectors.toList());
                OrderWarehouseLocationTransferNcmExcelPojo pojo=(OrderWarehouseLocationTransferNcmExcelPojo)ExcelUtils.mapTObject(records.get(0),OrderWarehouseLocationTransferNcmExcelPojo.class);;
                BeanUtils.copyProperties(tbOrderWarehouseLocationTransferNcm,pojo);
                list.add(pojo);
            }
            ExcelUtils.exportExcel(list,"库位转移Ncm单汇总", secondTitle,"库位转移Ncm单汇总",OrderWarehouseLocationTransferNcmExcelPojo.class,"库位转移Ncm单汇总.xls",res);
            return;
        }
    }
}
