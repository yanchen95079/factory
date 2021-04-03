package com.yc.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.yc.demo.commom.utils.DateUtil;
import com.yc.demo.commom.utils.PdfUtils;
import com.yc.demo.domain.TbPdfInfo;
import com.yc.demo.domain.TbPdfInfoExample;
import com.yc.demo.mapper.TbPdfInfoMapper;
import com.yc.demo.service.TbPdfInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName CeshiServiceImpl
 * @Date 2020/7/7 18:16
 * @Description：
 */
@Service
public class TbPdfInfoServiceImpl implements TbPdfInfoService {
    @Autowired
    private TbPdfInfoMapper tbPdfInfoMapper;

    private static String timeNumber="4";

    @Override
    public void insert(TbPdfInfo tbPdfInfo) {
        Date currentDate = DateUtil.getCurrentDate();
        String currentDateString = DateUtil.date2String(currentDate, DateUtil.DatePattern.YYYYMMDDHHmmss.getValue());
        tbPdfInfo.setCreateTime(currentDate);
        Map map = JSON.parseObject(tbPdfInfo.getInfo(), Map.class);
        if(map.get(timeNumber)!=null){
             map.put(timeNumber, currentDateString);
        }
        tbPdfInfo.setInfo(JSON.toJSONString(map));
        tbPdfInfoMapper.insertSelective(tbPdfInfo);
    }

    @Override
    public void update(TbPdfInfo tbPdfInfo) {
        tbPdfInfo.setUpdateTime(DateUtil.getCurrentDate());
        TbPdfInfoExample example=new TbPdfInfoExample();
        TbPdfInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbPdfInfo.getOrderNo())){
            criteria.andOrderNoEqualTo(tbPdfInfo.getOrderNo());
        }
        if(tbPdfInfo.getId()!=null){
            criteria.andIdEqualTo(tbPdfInfo.getId());
        }
        Map map = JSON.parseObject(tbPdfInfo.getInfo(), Map.class);
        tbPdfInfo.setInfo(JSON.toJSONString(map));
        tbPdfInfoMapper.updateByExampleSelective(tbPdfInfo,example);
    }

    @Override
    public void pdfOut(Long id) {
        TbPdfInfo pdfInfoById = selectById(id);
        PdfUtils.pdfout(JSON.parseObject(pdfInfoById.getInfo(),Map.class),pdfInfoById.getOrderNo(),pdfInfoById.getModelName());
    }

    @Override
    public TbPdfInfo selectById(Long id) {
        return tbPdfInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbPdfInfo> select(TbPdfInfo tbPdfInfo) {
        TbPdfInfoExample example=new TbPdfInfoExample();
        TbPdfInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbPdfInfo.getOrderNo())){
            criteria.andOrderNoEqualTo(tbPdfInfo.getOrderNo());
        }
        return tbPdfInfoMapper.selectByExample(example);
    }
}
