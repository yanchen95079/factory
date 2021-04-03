package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbMapRelation;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/4/4 1:09
 */
@Setter
@Getter
public class TbMapRelationForm extends TbMapRelation {
    private String orderBy;
}
