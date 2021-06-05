package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbRole;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/6/5 13:10
 */
@Setter
@Getter
public class TbRolePage extends TbRole {
    private Integer offset;
    private Integer limit;
}
