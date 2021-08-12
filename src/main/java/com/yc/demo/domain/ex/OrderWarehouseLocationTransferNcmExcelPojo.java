package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/8/12 18:56
 */
@Setter
@Getter
public class OrderWarehouseLocationTransferNcmExcelPojo {
    @Excel(name = "料号",orderNum = "0")
    private String itemNum;
    @Excel(name = "类型",orderNum = "1")
    private String ncmTypeName;
    @Excel(name = "原因说明",orderNum = "2")
    private String reason;
    @Excel(name = "操作人",  orderNum = "3")
    private String workName1;
    @Excel(name = "操作时间",  orderNum = "4")
    private String workDate1;
    @Excel(name = "新仓库",orderNum = "5")
    private String newWarehouse;
    @Excel(name = "新库位",orderNum = "6")
    private String newLocation;
    @Excel(name = "备注",orderNum = "7")
    private String remark;
    @Excel(name = "操作人",  orderNum = "8")
    private String workName2;
    @Excel(name = "操作时间",  orderNum = "9")
    private String workDate2;
}
