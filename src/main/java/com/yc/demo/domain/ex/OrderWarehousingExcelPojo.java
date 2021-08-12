package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/8/12 18:12
 */
@Setter
@Getter
public class OrderWarehousingExcelPojo {
    @Excel(name = "产线名称",  orderNum = "0")
    private String productionLineName;
    @Excel(name = "工单号",  orderNum = "1")
    private String orderNo;
    @Excel(name = "成品型号",  orderNum = "2")
    private String finishedProductModel;
    @Excel(name = "单位",  orderNum = "3")
    private String unit;
    @Excel(name = "数量",  orderNum = "4")
    private Integer quantity;
    @Excel(name = "操作人",  orderNum = "5")
    private String workName1;
    @Excel(name = "操作时间",  orderNum = "6")
    private String workDate1;
    @Excel(name = "整体单据备注",  orderNum = "7")
    private String workContent2;
    @Excel(name = "操作人",  orderNum = "8")
    private String workName2;
    @Excel(name = "操作时间",  orderNum = "9")
    private String workDate2;

}
