package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbMapRelation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yanchen
 * date 2021/4/4 0:59
 */
@Getter
@Setter
@ToString
public class MapRelationQueryParam extends TbMapRelation {

    private String level1like;

    private String level2like;

    private String level3like;

    private String level4like;

    private String level5like;

    private String level6like;

    private String level7like;

    private String level8like;

    private String level9like;

    private String level10like;
}