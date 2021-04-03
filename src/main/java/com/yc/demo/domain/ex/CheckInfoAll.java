package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbAssemblyContent;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName CheckInfoAll
 * @Date 2021/2/25 17:07
 * @Description：
 */
@Setter
@Getter
public class CheckInfoAll{
    /**
     * 检查单id
     */
    private Long id;
    /**
     * 检查单订单号
     */
    private String orderNo;
    /**
     * 检查单成品号
     */
    private String productNo;
    /**
     * 检查单序号
     */
    private String serialNo;
    /**
     * 检查单创建时间
     */
    private Date createTime;
    /**
     * 装配内容List
     */
    List<AssemblyContentEx> tbAssemblyContentList;
}
