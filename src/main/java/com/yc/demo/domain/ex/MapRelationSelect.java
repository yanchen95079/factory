package com.yc.demo.domain.ex;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author Yanchen
 * date 2021/6/4 13:52
 */
@Setter
@Getter
public class MapRelationSelect {
    private String configType;
    private Map<String,String> condition;
}
