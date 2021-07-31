package com.yc.demo.support;

import com.alibaba.fastjson.JSON;
import com.yc.demo.commom.constants.CommonConstant;
import com.yc.demo.commom.utils.groovy.GroovyUtil;
import com.yc.demo.domain.TbDefinitionStateFlow;
import com.yc.demo.domain.ex.OrderGeneralPojo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yanchen
 * date 2021/6/4 16:29
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlowNode {
    /**上一个链**/
    private FlowNode prex;
    /**下一个链**/
    private FlowNode next;
    /**本链**/
    private String aclCode;
    private Integer position;

    /**
     * 链表组装大客户
     * @param flag 是否正序
     * @param nodeList 总的大的node
     * @param sourceProjectRelationList 特殊配置
     * @param orderGeneralPojo 方法入参
     * @return List<DetailPayNode>
     */
    public static List<FlowNode> getNodeList(List<Map> sourceProjectRelationList, OrderGeneralPojo orderGeneralPojo, List<TbDefinitionStateFlow> nodeList, boolean flag){
        List<FlowNode> list=new ArrayList<>();
        Boolean continueFlag=false;
        for (TbDefinitionStateFlow tbDefinitionStateFlow : nodeList) {
            if(!CollectionUtils.isEmpty(sourceProjectRelationList)){
                List<Map> ruleList = sourceProjectRelationList.stream().filter(x -> x.get(CommonConstant.FLOW_POSITION).equals(String.valueOf(tbDefinitionStateFlow.getPosition()))).collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(ruleList)){
                    for (Map map : ruleList) {
                        Map<String,Object> mapRule=new HashMap<>();
                        mapRule.put("orderGeneralPojo",orderGeneralPojo);
                        Object eval = GroovyUtil.eval(String.valueOf(map.get(CommonConstant.RULE)),mapRule ,Object.class);
                        if(eval==null|| !Boolean.valueOf(String.valueOf(eval))){
                            continueFlag=true;
                        }
                    }
                }
            }
            if(continueFlag){
                continue;
            }
            FlowNode node=new FlowNode();
            node.setAclCode(tbDefinitionStateFlow.getAclCode());
            node.setPosition(tbDefinitionStateFlow.getPosition());
            list.add(node);
        }
        assembleNode(flag,list);
        return list;
    }

    private static void assembleNode(boolean flag, List<FlowNode> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            if(i==0){
                if(flag){
                    nodes.get(0).setPrex(null);
                }else {
                    nodes.get(0).setNext(null);
                }
            }else {
                if(flag){
                    nodes.get(i).setPrex(nodes.get(i-1));
                }else {
                    nodes.get(i).setNext(nodes.get(i-1));
                }
            }
            if(i+1>=nodes.size()){
                if(flag){
                    nodes.get(i).setNext(null);
                }else {
                    nodes.get(i).setPrex(null);
                }
            }else {
                if(flag){
                    nodes.get(i).setNext(nodes.get(i+1));
                }else {
                    nodes.get(i).setPrex(nodes.get(i+1));
                }
            }

        }
    }
}
