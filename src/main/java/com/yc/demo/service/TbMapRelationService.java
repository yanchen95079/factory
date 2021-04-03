package com.yc.demo.service;

import com.yc.demo.commom.exception.MyException;
import com.yc.demo.domain.TbMapRelation;
import com.yc.demo.domain.ex.TbMapRelationForm;

import java.util.List;
import java.util.Map;

/**
 * @author Yanchen
 * date 2021/4/4 0:05
 */
public interface TbMapRelationService {
    TbMapRelation insert(TbMapRelation tbMapRelation);

    void delAndBatchInsert(TbMapRelation mapUpdate, List<TbMapRelation> list);

    void batchInsert(List<TbMapRelation> list);

    List<TbMapRelation> select(TbMapRelationForm tbMapRelation);

    List<String> getMapLikeRelation(String configType, Map<String,String> condition, Map<String,String> likeCondition)throws Exception ;

    public <T> List<T> getMapRelation(String configType, Map<String, String> condition, Class<T> clazz) throws Exception ;

}


