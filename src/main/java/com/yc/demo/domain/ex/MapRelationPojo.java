package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbMapRelation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * date 2021/6/4 13:49
 */
@Setter
@Getter
public class MapRelationPojo {
    private Long id;
    Integer position;
    String configType;
    Map<String,String> map;
}
