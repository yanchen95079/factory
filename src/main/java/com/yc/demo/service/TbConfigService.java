package com.yc.demo.service;

import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbMapRelation;
import com.yc.demo.domain.ex.ConfigForm;

import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName TbConfigService
 * @Date 2021/2/25 11:58
 * @Description：
 */
public interface TbConfigService {

    public List<TbConfig> select(TbConfig config);

    void insert(TbConfig config);

    void update(TbConfig config);

    public List<TbConfig>  selectAllConfigKey(ConfigForm configForm);

}
