package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yanchen
 * date 2021/8/12 18:39
 */
@Getter
@Setter
public class OrderShortageExcelPojo {
    @Excel(name = "预计到货日期",orderNum = "0")
    private Date estimateTime;
    @Excel(name = "操作人",  orderNum = "1")
    private String workName1;
    @Excel(name = "操作时间",  orderNum = "2")
    private String workDate1;
    @Excel(name = "实际到货日期",orderNum = "3")
    private Date actualTime;
    @Excel(name = "实际到货数量",orderNum = "4")
    private Integer actualQuantity;
    @Excel(name = "操作人",  orderNum = "5")
    private String workName2;
    @Excel(name = "操作时间",  orderNum = "6")
    private String workDate2;
}
