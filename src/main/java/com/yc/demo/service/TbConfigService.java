package com.yc.demo.service;

import com.yc.demo.domain.TbConfig;

import java.util.List;

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
}
