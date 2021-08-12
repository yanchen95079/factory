package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/8/12 16:39
 */
@Getter
@Setter
public class OrderProductionSuppleExcelPojo {
    @Excel(name = "产线名称",  orderNum = "0")
    private String productionLineName;
    @Excel(name = "工单号",  orderNum = "1")
    private String orderNo;
    @Excel(name = "料号",  orderNum = "2")
    private String itemNo;
    @Excel(name = "需求数量",  orderNum = "3")
    private Integer quantity;
    @Excel(name = "原因",  orderNum = "4")
    private String reason;
    @Excel(name = "备注",  orderNum = "5")
    private String remark;
    @Excel(name = "操作人",  orderNum = "6")
    private String workName1;
    @Excel(name = "操作时间",  orderNum = "7")
    private String workDate1;
    @Excel(name = "仓库",  orderNum = "8")
    private String warehouse;
    @Excel(name = "库位",  orderNum = "9")
    private String location;
    @Excel(name = "实际发货数量",  orderNum = "10")
    private Integer quantityActual;
    @Excel(name = "操作人",  orderNum = "11")
    private String workName2;
    @Excel(name = "操作时间",  orderNum = "12")
    private String workDate2;
}
