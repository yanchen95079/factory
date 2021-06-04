package com.yc.demo.service;

import com.yc.demo.domain.TbDefinitionStateFlow;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/4 15:41
 */
public interface TbDefinitionStateFlowService {
    List<TbDefinitionStateFlow> selectOrderByPosition(TbDefinitionStateFlow flow);
}
