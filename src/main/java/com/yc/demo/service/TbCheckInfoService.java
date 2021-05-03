package com.yc.demo.service;

import com.github.pagehelper.PageInfo;
import com.yc.demo.domain.TbCheckInfo;
import com.yc.demo.domain.TbCheckInfoDetail;
import com.yc.demo.domain.ex.CheckInfoAll;
import com.yc.demo.domain.ex.CheckInfoSelectPage;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName CheckInfoService
 * @Date 2021/2/25 12:03
 * @Description：
 */
public interface TbCheckInfoService {
    /**
     * 分页查询
     * @param checkInfoSelectPage
     * @return
     */
    PageInfo<CheckInfoSelectPage> checkInfoSelectPage(CheckInfoSelectPage checkInfoSelectPage);

    void insert(TbCheckInfo tbCheckInfo);

    List<TbCheckInfo> select(TbCheckInfo tbCheckInfo);

    List<TbCheckInfoDetail> selectDetail(TbCheckInfoDetail tbCheckInfoDetail);

    void batchInsertDetail(List<TbCheckInfoDetail> list);

    /**
     *
     * @param list
     * @param infoState 0未完成 1说明整体已经完成 需要修改总表checkInfo的state状态
     */
    void batchUpdateDetail(List<TbCheckInfoDetail> list,int infoState);

    /**
     *
     * @param tbCheckInfo
     * @param samplingFlag 1基础 0抽样
     * @return
     */
    CheckInfoAll selectInfoALL(TbCheckInfo tbCheckInfo,Integer samplingFlag);

    void copyCheck(String sourceConfigKey,String configKey);


    List<String> selectAllConfigKey(TbCheckInfo record);

    void outExcel(TbCheckInfo tbCheckInfo, Integer samplingFlag,HttpServletResponse response);
}
