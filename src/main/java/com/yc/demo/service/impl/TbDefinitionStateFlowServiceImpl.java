package com.yc.demo.service.impl;

import com.yc.demo.domain.TbDefinitionStateFlow;
import com.yc.demo.domain.TbDefinitionStateFlowExample;
import com.yc.demo.mapper.TbDefinitionStateFlowMapper;
import com.yc.demo.service.TbDefinitionStateFlowService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/4 15:43
 */
@Service
public class TbDefinitionStateFlowServiceImpl implements TbDefinitionStateFlowService {
    @Autowired
    private TbDefinitionStateFlowMapper tbDefinitionStateFlowMapper;
    @Override
    public List<TbDefinitionStateFlow> selectOrderByPosition(TbDefinitionStateFlow flow) {
        TbDefinitionStateFlowExample example=new TbDefinitionStateFlowExample();
        TbDefinitionStateFlowExample.Criteria criteria = example.createCriteria();
        if(flow.getDefType()!=null){
            criteria.andDefTypeEqualTo(flow.getDefType());
        }
        example.setOrderByClause(" position asc");
        return tbDefinitionStateFlowMapper.selectByExample(example);
    }
}
