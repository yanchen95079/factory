package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbAcl;
import com.yc.demo.domain.TbRole;
import com.yc.demo.domain.TbUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbUserEx
 * @Date 2021/5/31 17:07
 * @Description：
 */
@Setter
@Getter
public class TbUserEx extends TbUser {
    List<Long> userCodes;
    List<TbRole> roleList;
    List<TbAcl> aclList;
}
