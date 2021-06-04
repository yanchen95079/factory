package com.yc.demo.service;

import com.yc.demo.domain.TbAcl;
import com.yc.demo.domain.ex.TbAclEx;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName AclService
 * @Date 2021/5/31 15:18
 * @Description：
 */
public interface AclService {

    void insert(TbAcl acl);

    void updateById(TbAcl acl);

    List<TbAcl> select(TbAclEx acl);
}
