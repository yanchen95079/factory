package com.yc.demo.service.impl;

import com.yc.demo.service.TbOrderGeneralService;
import org.springframework.stereotype.Service;

/**
 * @author Yanchen
 * date 2021/5/29 20:38
 */
@Service
public class TbOrderGeneralServiceImpl implements TbOrderGeneralService {
    @Override
    public void insert(boolean next) {
        //查询传入的group_uuid没有自己生成一个
        //找到这个权限下所有的工作流流程
        //判断当前这个Type对应的流程 是否为第一个流程
        //否就弹错误
        // 是就新建总表OrderGeneral
        if(next){
            //上一个acl为当前的 当前acl和user为工作流转到的（下一个 下一个user为空） 下一个为下一个的下一个 如果到了尾部 需要修改general表为完成
        }else {
            //上一个acl空 当前acl和user为当前 下一个为下一个 如果到了尾部 需要修改general表为完成
        }
        //新建对应的子业务的数据
        //新建所有的工作流流程 注意第一个工作流需要添加操作人和操作时间和操作内容
    }

    @Override
    public void nextStep() {
        //查询groupuuid是否有对应的单子 没有直接insert(true) return
        //有的话判断当前人是否和general当前人一样 不一样不可以处理
        // update对应的子业务的数据
        //update对应的工作流log
        //上一个acl为当前的 当前acl和user为工作流转到的（下一个 下一个user为空） 下一个为下一个的下一个 如果到了尾部 需要修改general表为完成


    }

    @Override
    public void backStep() {
        //查询groupuuid 如果没有抛出异常 没有查到单子
        //查看单子上一步acl是否为空  为空则返回没有上一步
        // update对应的子业务的数据 虽然这里不可能update
        //update对应的工作流log
        //上一个acl为上一个的上一个 当前acl和user为工作流转到的（上一个 user赋值空按照角色划分） 下一个为当前这个

    }

    @Override
    public void saveStep() {
        //查询groupuuid是否有对应的单子 没有直接insert(false) return
        // update对应的子业务的数据
        //update对应的工作流log
    }

    @Override
    public void acceptance() {
        //查询groupuuid 如果没有抛出异常 没有查到单子
        //查询当前的单子 是否当前人为空 如果不是提示已经有人受理了
        //查询当前单子当前权限和传入人的权限是否一致 如果不一致返回您没有权限受理
        //更改general表的当前处理人
    }


    @Override
    public void delete() {
        //根据id删除单子,并且根据group把对应的子业务和工作流log都删除
    }

    @Override
    public void select() {
        //查找所有单子 按照当前人为自己的排在前面 然后是当前人为空的 然后是时间
    }
}
