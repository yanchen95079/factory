package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbStatusFlowRecord;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/8/12 15:27
 */
@Getter
@Setter
public class TbStatusFlowRecordEx extends TbStatusFlowRecord {
    private List<String> groupUuidList;
}
