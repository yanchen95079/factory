package com.yc.demo.support;

import com.yc.demo.domain.TbDefinitionStateFlow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
     * @return List<DetailPayNode>
     */
    public static List<FlowNode> getNodeList(List<TbDefinitionStateFlow> nodeList, boolean flag){
        List<FlowNode> list=new ArrayList<>();
        for (TbDefinitionStateFlow tbDefinitionStateFlow : nodeList) {
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
