package com.yc.demo.service;

import com.github.pagehelper.PageInfo;
import com.yc.demo.domain.TbOrderGeneral;
import com.yc.demo.domain.ex.TbOrderGeneralEx;
import com.yc.demo.domain.ex.OrderGeneralDetailPojo;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import com.yc.demo.domain.ex.TbOrderGeneralSelectPage;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/5/29 20:34
 */
public interface TbOrderGeneralService {
    void insert(OrderGeneralPojo orderGeneralPojo, boolean next);

    /**
     * 下一步
     */
    void nextStep(OrderGeneralPojo orderGeneralPojo);
    /**
     * 上一步
     */
    void backStep(OrderGeneralPojo orderGeneralPojo);

    /**
     * 保存当前这步
     */
    void saveStep(OrderGeneralPojo orderGeneralPojo);

    /**
     * 受理
     */
    void acceptance(OrderGeneralPojo orderGeneralPojo);
    void deleteByGroupUuid(String  groupUuid);

    PageInfo<TbOrderGeneral> selectPage(TbOrderGeneralSelectPage tbOrderGeneralSelectPage);

    OrderGeneralDetailPojo selectDetailByGroupUuid(String groupUuid);

    List<TbOrderGeneral> select(TbOrderGeneral tbOrderGeneral);

    List<TbOrderGeneral> selectEx(TbOrderGeneralEx tbOrderGeneralEx);
}
