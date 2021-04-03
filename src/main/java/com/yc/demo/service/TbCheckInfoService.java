package com.yc.demo.service;

import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbCheckInfoDetail;
import com.yc.demo.domain.ex.CheckInfoAll;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName CheckInfoService
 * @Date 2021/2/25 12:03
 * @Description：
 */
public interface TbCheckInfoService {

    void insert(TbCheckInfo tbCheckInfo);

    List<TbCheckInfo> select(TbCheckInfo tbCheckInfo);

    List<TbCheckInfoDetail> selectDetail(TbCheckInfoDetail tbCheckInfoDetail);

    void batchInsertDetail(List<TbCheckInfoDetail> list);

    void batchUpdateDetail(List<TbCheckInfoDetail> list);

    /**
     *
     * @param tbCheckInfo
     * @return
     */
    CheckInfoAll selectInfoALL(TbCheckInfo tbCheckInfo);

    void copyCheck(String sourceConfigKey,String configKey);
}
