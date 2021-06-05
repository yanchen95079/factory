package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbAcl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbAclEx
 * @Date 2021/5/31 17:14
 * @Description：
 */
@Setter
@Getter
public class TbAclEx extends TbAcl {
    private List<String> aclCodes;
    private String nameLike;
}
