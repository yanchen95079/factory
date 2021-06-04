package com.yc.demo.service;

import com.yc.demo.domain.TbConfig;
import com.yc.demo.domain.TbUser;
import com.yc.demo.domain.ex.TbUserEx;

import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * date 2021/3/21 3:53
 */
public interface TbUserService {

    public List<TbUser> select(TbUser tbUser);

    public List<TbUser> selectEx(TbUserEx tbUser);

    public Map<Long,String> selectAllUserName();

    void insert(TbUser tbUser);

    void update(TbUser tbUser);

    TbUserEx login(TbUser tbUser);
}
