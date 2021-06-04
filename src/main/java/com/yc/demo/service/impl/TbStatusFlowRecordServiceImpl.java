package com.yc.demo.service.impl;

import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.TbStatusFlowRecord;
import com.yc.demo.domain.TbStatusFlowRecordExample;
import com.yc.demo.mapper.TbStatusFlowRecordMapper;
import com.yc.demo.service.TbStatusFlowRecordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/4 18:08
 */
@Service
public class TbStatusFlowRecordServiceImpl implements TbStatusFlowRecordService {
    @Autowired
    private TbStatusFlowRecordMapper tbStatusFlowRecordMapper;
    @Override
    public void batchInsert(List<TbStatusFlowRecord> list) {
        tbStatusFlowRecordMapper.batchInsert(list);
    }

    @Override
    public void updateByGroupIdAndTypeAndAcl(TbStatusFlowRecord record) {
        TbStatusFlowRecord recordSelect=new TbStatusFlowRecord();
        recordSelect.setGroupId(record.getGroupId());
        recordSelect.setAclCode(record.getAclCode());
        recordSelect.setDefType(record.getDefType());
        List<TbStatusFlowRecord> select = this.select(recordSelect);
        if(CollectionUtils.isEmpty(select)){
            //说明此流程为新添加的  之前没有 需要自动加上
            tbStatusFlowRecordMapper.insert(record);
        }
        if(select.size()>1){
            throw new MyException(500,"流程log有重复");
        }
        record.setId(select.get(0).getId());
        tbStatusFlowRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByUuid(String groupUuid) {
        TbStatusFlowRecordExample example=new TbStatusFlowRecordExample();
        example.createCriteria().andGroupIdEqualTo(groupUuid);
        tbStatusFlowRecordMapper.deleteByExample(example);
    }

    @Override
    public List<TbStatusFlowRecord> select(TbStatusFlowRecord record) {
        TbStatusFlowRecordExample example=new TbStatusFlowRecordExample();
        TbStatusFlowRecordExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(record.getAclCode())){
            criteria.andAclCodeEqualTo(record.getAclCode());
        }
        if(StringUtils.isNotEmpty(record.getGroupId())){
            criteria.andGroupIdEqualTo(record.getGroupId());
        }
        if(record.getDefType()!=null){
            criteria.andDefTypeEqualTo(record.getDefType());
        }
        return tbStatusFlowRecordMapper.selectByExample(example);
    }
}
