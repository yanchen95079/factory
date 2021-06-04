package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName TbRoleEx
 * @Date 2021/5/31 17:44
 * @Description：
 */
@Setter
@Getter
public class TbRoleEx extends TbRole {
    private List<String> roleCodes;
}
