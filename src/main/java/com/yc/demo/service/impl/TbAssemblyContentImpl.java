package com.yc.demo.service.impl;

import com.yc.demo.commom.exception.MyException;
import com.yc.demo.commom.utils.DateUtil;
import com.yc.demo.domain.TbAssemblyContent;
import com.yc.demo.domain.TbAssemblyContentExample;
import com.yc.demo.domain.TbTestItems;
import com.yc.demo.domain.ex.AssemblyContentForm;
import com.yc.demo.mapper.TbAssemblyContentMapper;
import com.yc.demo.service.TbAssemblyContentService;
import com.yc.demo.service.TbTestItemsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbAssemblyContentImpl
 * @Date 2021/2/25 12:05
 * @Description：
 */
@Service
public class TbAssemblyContentImpl implements TbAssemblyContentService {
    @Autowired
    private TbAssemblyContentMapper tbAssemblyContentMapper;
    @Autowired
    private TbTestItemsService tbTestItemsService;
    @Override
    public List<TbAssemblyContent> select(AssemblyContentForm tbAssemblyContent) {
        TbAssemblyContentExample example=new TbAssemblyContentExample();
        TbAssemblyContentExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(tbAssemblyContent.getConfigKey())){
            criteria.andConfigKeyEqualTo(tbAssemblyContent.getConfigKey());
        }
        if(tbAssemblyContent.getId()!=null){
            criteria.andIdEqualTo(tbAssemblyContent.getId());
        }
        if(!CollectionUtils.isEmpty(tbAssemblyContent.getIds())){
            criteria.andIdIn(tbAssemblyContent.getIds());
        }
        example.setOrderByClause(" position asc");
        return  tbAssemblyContentMapper.selectByExample(example);
    }

    @Override
    public TbAssemblyContent insert(TbAssemblyContent tbAssemblyContent) {
        Date currentDate = DateUtil.getCurrentDate();
        //添加检测项目
        tbAssemblyContent.setCreateTime(currentDate);
        tbAssemblyContent.setUpdateTime(currentDate);
        tbAssemblyContentMapper.insertSelective(tbAssemblyContent);
        return tbAssemblyContent;
    }

    @Override
    public TbAssemblyContent updateById(TbAssemblyContent tbAssemblyContent) {
        tbAssemblyContent.setUpdateTime(DateUtil.getCurrentDate());
        tbAssemblyContentMapper.updateByPrimaryKeySelective(tbAssemblyContent);
        return tbAssemblyContent;
    }

    @Override
    public void deleteById(Long id) {
        TbTestItems items=new TbTestItems();
        items.setAssemblyContentId(id);
        List<TbTestItems> select = tbTestItemsService.select(items);
        if(!CollectionUtils.isEmpty(select)){
            throw new MyException(500,"该装配内容下已经有检测项目,不可删除");
        }
        tbAssemblyContentMapper.deleteByPrimaryKey(id);
    }
}
