package com.yc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.commom.exception.MyException;
import com.yc.demo.commom.mapstruct.convert.Convert;
import com.yc.demo.commom.utils.DateUtil;
import com.yc.demo.domain.*;
import com.yc.demo.domain.ex.*;
import com.yc.demo.mapper.TbCheckInfoDetailMapper;
import com.yc.demo.mapper.TbCheckInfoMapper;
import com.yc.demo.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Yanchen
 * @ClassName CheckInfoServiceImpl
 * @Date 2021/2/25 12:03
 * @Description：
 */
@Service
public class TbCheckInfoServiceImpl implements TbCheckInfoService {
    @Autowired
    private TbMapRelationService tbMapRelationService;
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TbCheckInfoMapper tbCheckInfoMapper;
    @Autowired
    private TbCheckInfoDetailMapper tbCheckInfoDetailMapper;
    @Autowired
    private TbTestItemsService tbTestItemsService;
    @Autowired
    private TbAssemblyContentService tbAssemblyContentService;
    @Autowired
    private Convert convert;
    @Autowired
    private TbConfigService tbConfigService;

    @Override
    public  PageInfo<CheckInfoSelectPage> checkInfoSelectPage(CheckInfoSelectPage checkInfoSelectPage) {
        TbCheckInfoExample example = new TbCheckInfoExample();
        TbCheckInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(checkInfoSelectPage.getConfigKey())) {
            criteria.andConfigKeyEqualTo(checkInfoSelectPage.getConfigKey());
        }
        if (checkInfoSelectPage.getState()!=null) {
            criteria.andStateEqualTo(checkInfoSelectPage.getState());
        }
        if (StringUtils.isNotEmpty(checkInfoSelectPage.getOrderNoLike())) {
            criteria.andOrderNoLike(checkInfoSelectPage.getOrderNoLike()+"%");
        }
        if (StringUtils.isNotEmpty(checkInfoSelectPage.getProductNoLike())) {
            criteria.andProductNoLike(checkInfoSelectPage.getProductNoLike()+"%");
        }
        if (StringUtils.isNotEmpty(checkInfoSelectPage.getSerialNoLike())) {
            criteria.andSerialNoLike(checkInfoSelectPage.getSerialNoLike()+"%");
        }
        if(checkInfoSelectPage.getCreateTimeStart()!=null && checkInfoSelectPage.getCreateTimeEnd()!=null){
            criteria.andCreateTimeBetween(checkInfoSelectPage.getCreateTimeStart(),checkInfoSelectPage.getCreateTimeEnd());
        }
        PageHelper.startPage(checkInfoSelectPage.getOffset(), checkInfoSelectPage.getLimit());
        List<TbCheckInfo> tbCheckInfos = tbCheckInfoMapper.selectByExample(example);
        PageInfo<TbCheckInfo> pageInfo = new PageInfo<>(tbCheckInfos);
        PageInfo<CheckInfoSelectPage> pageInfoCopy = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo,pageInfoCopy);
        List<CheckInfoSelectPage> checkInfoSelectPages = convert.tbCheckInfoToPage(tbCheckInfos);
        pageInfoCopy.setList(checkInfoSelectPages);
        return pageInfoCopy;
    }

    @Override
    public void insert(TbCheckInfo tbCheckInfo) {
        //校验单子是否存在
        TbCheckInfo tbCheckInfoSelect=new TbCheckInfo();
        tbCheckInfoSelect.setConfigKey(tbCheckInfo.getConfigKey());
        tbCheckInfoSelect.setProductNo(tbCheckInfo.getProductNo());
        tbCheckInfoSelect.setSerialNo(tbCheckInfo.getSerialNo());
        tbCheckInfoSelect.setOrderNo(tbCheckInfo.getOrderNo());
        if(!CollectionUtils.isEmpty(this.select(tbCheckInfoSelect))){
            throw new MyException(500,"您扫描的质检单已经存在");
        }

        Date currentDate = DateUtil.getCurrentDate();
        //添加检查单
        tbCheckInfo.setCreateTime(currentDate);
        tbCheckInfo.setUpdateTime(currentDate);
        tbCheckInfoMapper.insertSelective(tbCheckInfo);
        //拿到对应检测项目的配置 添加detail
        TbTestItems tbTestItems = new TbTestItems();
        tbTestItems.setConfigKey(tbCheckInfo.getConfigKey());
        List<TbTestItems> select = tbTestItemsService.select(tbTestItems);
        //添加原始检查单详情
        List<TbCheckInfoDetail> list = new ArrayList<>();
        for (TbTestItems testItems : select) {
            TbCheckInfoDetail detail = new TbCheckInfoDetail();
            detail.setConfigKey(tbCheckInfo.getConfigKey());
            detail.setCheckInfoId(tbCheckInfo.getId());
            detail.setTestItemsId(testItems.getId());
            detail.setCreateTime(currentDate);
            detail.setUpdateTime(currentDate);
            detail.setOrderNo(tbCheckInfo.getOrderNo());
            detail.setSerialNo(tbCheckInfo.getSerialNo());
            detail.setProductNo(tbCheckInfo.getProductNo());
            detail.setCreateUser(tbCheckInfo.getCreateUser());
            detail.setUpdateUser(tbCheckInfo.getUpdateUser());
            detail.setEnable(1);
            list.add(detail);
        }
        if (!CollectionUtils.isEmpty(list)) {
            tbCheckInfoDetailMapper.batchInsert(list);
        }
    }

    @Override
    public List<TbCheckInfo> select(TbCheckInfo tbCheckInfo) {
        TbCheckInfoExample example = new TbCheckInfoExample();
        TbCheckInfoExample.Criteria criteria = example.createCriteria();
        if (tbCheckInfo.getId()!=null) {
            criteria.andIdEqualTo(tbCheckInfo.getId());
        }
        if (StringUtils.isNotEmpty(tbCheckInfo.getConfigKey())) {
            criteria.andConfigKeyEqualTo(tbCheckInfo.getConfigKey());
        }
        if (StringUtils.isNotEmpty(tbCheckInfo.getOrderNo())) {
            criteria.andOrderNoEqualTo(tbCheckInfo.getOrderNo());
        }
        if (StringUtils.isNotEmpty(tbCheckInfo.getProductNo())) {
            criteria.andProductNoEqualTo(tbCheckInfo.getProductNo());
        }
        if (StringUtils.isNotEmpty(tbCheckInfo.getSerialNo())) {
            criteria.andSerialNoEqualTo(tbCheckInfo.getSerialNo());
        }
        return tbCheckInfoMapper.selectByExample(example);
    }

    @Override
    public List<TbCheckInfoDetail> selectDetail(TbCheckInfoDetail tbCheckInfoDetail) {
        TbCheckInfoDetailExample example = new TbCheckInfoDetailExample();
        TbCheckInfoDetailExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(tbCheckInfoDetail.getConfigKey())) {
            criteria.andConfigKeyEqualTo(tbCheckInfoDetail.getConfigKey());
        }
        if (StringUtils.isNotEmpty(tbCheckInfoDetail.getOrderNo())) {
            criteria.andOrderNoEqualTo(tbCheckInfoDetail.getOrderNo());
        }
        if (StringUtils.isNotEmpty(tbCheckInfoDetail.getProductNo())) {
            criteria.andProductNoEqualTo(tbCheckInfoDetail.getProductNo());
        }
        if (StringUtils.isNotEmpty(tbCheckInfoDetail.getSerialNo())) {
            criteria.andSerialNoEqualTo(tbCheckInfoDetail.getSerialNo());
        }
        if (tbCheckInfoDetail.getCheckInfoId()!=null) {
            criteria.andIdEqualTo(tbCheckInfoDetail.getCheckInfoId());
        }
        if(tbCheckInfoDetail.getTestItemsId()!=null){
            criteria.andTestItemsIdEqualTo(tbCheckInfoDetail.getTestItemsId());
        }
        return tbCheckInfoDetailMapper.selectByExample(example);
    }

    @Override
    public void batchInsertDetail(List<TbCheckInfoDetail> list) {

        int mul = 500;
        int count = list.size() / mul;
        int remainder = list.size() % mul;
        if (count == 0) {
            tbCheckInfoDetailMapper.batchInsert(list);
        }
        else {

            for (int i = 0; i <= count; i++) {
                List<TbCheckInfoDetail> list2 = new ArrayList<>();
                if (i + 1 > count) {
                    if (remainder > 0) {
                        list2 = list.stream().skip(i * mul).limit(remainder).collect(Collectors.toList());
                        tbCheckInfoDetailMapper.batchInsert(list2);
                    }
                }
                else {
                    list2 = list.stream().skip(i * mul).limit(mul).collect(Collectors.toList());
                    tbCheckInfoDetailMapper.batchInsert(list2);
                }
            }
        }


    }

    @Override
    public void batchUpdateDetail(List<TbCheckInfoDetail> list,int infoState) {
        //前端已经判断了数值是否正确,所以我们不需要再去判断了 只拿到正确不正确即可
        Date currentDate = DateUtil.getCurrentDate();
        list.forEach(x->x.setUpdateTime(currentDate));
        tbCheckInfoDetailMapper.batchUpdate(list);
        if(infoState==1){
            Set<Long> collect = list.stream().map(TbCheckInfoDetail::getCheckInfoId).collect(Collectors.toSet());
            for (Long id : collect) {
                TbCheckInfo record=new TbCheckInfo();
                record.setId(id);
                record.setState(infoState);
                tbCheckInfoMapper.updateByPrimaryKeySelective(record);
            }
        }
    }

    @Override
    public CheckInfoAll selectInfoALL(TbCheckInfo tbCheckInfo,Integer samplingFlag) {
        //拿到用户数据
        Map<Long, String> user = tbUserService.selectAllUserName();
        CheckInfoAll result=new CheckInfoAll();
        //组装检查表
        List<TbCheckInfo> select = this.select(tbCheckInfo);
        if(CollectionUtils.isEmpty(select)){
            throw new MyException(500,"没有此检查单");
        }
        result.setOrderNo(select.get(0).getOrderNo());
        result.setSerialNo(select.get(0).getSerialNo());
        result.setProductNo(select.get(0).getProductNo());
        result.setCreateTime(select.get(0).getCreateTime());
        result.setId(select.get(0).getId());
        //组装装配内容
        AssemblyContentForm tbAssemblyContent=new AssemblyContentForm();
        tbAssemblyContent.setConfigKey(select.get(0).getConfigKey());
        List<TbAssemblyContent> tbAssemblyContentList = tbAssemblyContentService.select(tbAssemblyContent);
        List<AssemblyContentEx> assemblyContentExeList = convert.tbAssemblyContentToEx(tbAssemblyContentList);
        assemblyContentExeList=assemblyContentExeList.stream().sorted(Comparator.comparing(AssemblyContentEx::getPosition)).collect(Collectors.toList());
        //检测内容
        TestItemsForm tbTestItems=new TestItemsForm();
        tbTestItems.setConfigKey(select.get(0).getConfigKey());
        tbTestItems.setAssemblyContentIds(assemblyContentExeList.stream().map(AssemblyContentEx::getId).collect(Collectors.toList()));
        List<TestItemsForm> tbTestItemsList = tbTestItemsService.selectAll(tbTestItems);
        List<TestItemsEx> testItemsExList = convert.tbTestItemsFormToEx(tbTestItemsList);
        //订单详情
        TbCheckInfoDetail tbCheckInfoDetail=new TbCheckInfoDetail();
        tbCheckInfoDetail.setConfigKey(select.get(0).getConfigKey());
        tbCheckInfoDetail.setOrderNo(select.get(0).getOrderNo());
        tbCheckInfoDetail.setSerialNo(select.get(0).getSerialNo());
        tbCheckInfoDetail.setProductNo(select.get(0).getProductNo());
        List<TbCheckInfoDetail> tbCheckInfoDetails = this.selectDetail(tbCheckInfoDetail);
        Map<Long, List<TbCheckInfoDetail>> tbCheckInfoDetailMap = tbCheckInfoDetails.stream().collect(Collectors.groupingBy(TbCheckInfoDetail::getTestItemsId));
        for (TestItemsEx testItemsEx : testItemsExList) {
            List<TbCheckInfoDetail> detailList = tbCheckInfoDetailMap.get(testItemsEx.getId());
            if(CollectionUtils.isEmpty(detailList)){
                testItemsEx.setTbCheckInfoDetail(new TbCheckInfoDetail());
            }else {
                //项目和详情是一对一关系
                TbCheckInfoDetail detail = detailList.get(0);
                if(detail.getCreateUser()!=null){
                    detail.setCreateUserName(user.get(detail.getCreateUser()));
                }
                if(detail.getUpdateUser()!=null){
                    detail.setUpdateUserName(user.get(detail.getUpdateUser()));
                }
                testItemsEx.setTbCheckInfoDetail(detail);
            }
        }
        //检测内容转map
        Map<Long, List<TestItemsEx>>  testItemsExMap = testItemsExList.stream().collect(Collectors.groupingBy(TestItemsEx::getAssemblyContentId));
        //组装检测内容及其订单详情
        boolean flag=true;
        for (AssemblyContentEx assemblyContentEx : assemblyContentExeList) {
            List<TestItemsEx> testItemsExes = testItemsExMap.get(assemblyContentEx.getId());
            if(!CollectionUtils.isEmpty(testItemsExes)){
                testItemsExes = testItemsExes.stream().sorted(Comparator.comparing(TbTestItems::getPosition)).collect(Collectors.toList());
            }
            assemblyContentEx.setTestItemsList(testItemsExes);
            if(flag){
                //如果不是所有的都有成功结果,那么就是这一项为可编辑项目
                if(!CollectionUtils.isEmpty(testItemsExes)&&!testItemsExes.stream().allMatch(x -> x.getTbCheckInfoDetail().getCheckResult()!=null && x.getTbCheckInfoDetail().getCheckResult()==1)){
                    //如果外面选择只为基础
                    if(samplingFlag==null || samplingFlag==1){
                        //判断数据库如果为抽检 那么为false
                        if(assemblyContentEx.getSamplingFlag()!=null&&assemblyContentEx.getSamplingFlag()==0){
                            assemblyContentEx.setEditFlat(false);
                        }else {
                            assemblyContentEx.setEditFlat(true);
                            flag=false;
                        }
                    }else {
                        //如果外面选择可以为抽检  那么就不判断数据库抽检状态
                        assemblyContentEx.setEditFlat(true);
                        flag=false;
                    }
                }
            }
        }


        result.setTbAssemblyContentList(assemblyContentExeList);
        return result;
    }

    @Override
    public void copyCheck(String sourceConfigKey,String configKey) {
        //校验复制的项目下是否有模板  如果有那么不允许检测
        AssemblyContentForm tbAssemblyContent=new AssemblyContentForm();
        tbAssemblyContent.setConfigKey(configKey);
        List<TbAssemblyContent> modelFlagList = tbAssemblyContentService.select(tbAssemblyContent);
        if(!CollectionUtils.isEmpty(modelFlagList)){
            throw new MyException(500,"此被复制的检测项下已经存在模板,不可复制");
        }
        //添加装配内容和检测项目
        tbAssemblyContent.setConfigKey(sourceConfigKey);
        List<TbAssemblyContent> assemblyContentList = tbAssemblyContentService.select(tbAssemblyContent);
        if(CollectionUtils.isEmpty(assemblyContentList)){
            throw new MyException(500,"此复制的检测项下没有模板可以复制");
        }
        List<Long> assemIds=assemblyContentList.stream().map(TbAssemblyContent::getId).collect(Collectors.toList());
        List<TbTestItems> tbTestItems = tbTestItemsService.selectByAssemblyContentIds(assemIds);
        for (TbAssemblyContent assemblyContent : assemblyContentList) {
            TbAssemblyContent insert=new TbAssemblyContent();
            BeanUtils.copyProperties(assemblyContent,insert);
            insert.setId(null);
            insert.setConfigKey(configKey);
            tbAssemblyContentService.insert(insert);
            List<TbTestItems> collect = tbTestItems.stream().filter(x -> x.getAssemblyContentId().equals(assemblyContent.getId())).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(collect)){
                for (TbTestItems testItems : collect) {
                    TbTestItems insertItems=new TbTestItems();
                    BeanUtils.copyProperties(testItems,insertItems);
                    insertItems.setId(null);
                    insertItems.setConfigKey(configKey);
                    insertItems.setAssemblyContentId(insert.getId());
                    if(insertItems.getItemType()==0){
                        tbTestItemsService.insert(insertItems,null);
                    }else {
                        //查找maprelation数据 替换他的configKey 批量添加
                        TbMapRelationForm tbMapRelation=new TbMapRelationForm();
                        tbMapRelation.setConfigType(CommonConstant.TEST_ITEM_ENUM);
                        tbMapRelation.setLevel2(String.valueOf(testItems.getId()));
                        tbTestItemsService.insert(insertItems,tbMapRelationService.select(tbMapRelation));
                    }

                }
            }
        }
    }


}
