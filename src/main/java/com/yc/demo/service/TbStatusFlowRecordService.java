package com.yc.demo.service;

import com.yc.demo.domain.TbStatusFlowRecord;
import com.yc.demo.domain.ex.TbStatusFlowRecordEx;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/4 18:04
 */
public interface TbStatusFlowRecordService {
    public void batchInsert(List<TbStatusFlowRecord> list);
    public void updateByGroupIdAndTypeAndAcl(TbStatusFlowRecord record);
    public void deleteByUuid(String groupUuid);
    public List<TbStatusFlowRecord>  select(TbStatusFlowRecord record);
    public List<TbStatusFlowRecord>  selectEx(TbStatusFlowRecordEx record);
}
