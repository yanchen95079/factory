package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

/**
 * @author Yanchen
 * date 2021/8/12 17:37
 */
@Setter
@Getter
public class OrderWarehouseLocationTransferExcelPojo {
    @Excel(name = "料号",orderNum = "0")
    private String itemNum;
    @Excel(name = "老仓库",orderNum = "1")
    private String originalWarehouse;
    @Excel(name = "老库位",orderNum = "2")
    private String originalLocation;
    @Excel(name = "新仓库",orderNum = "3")
    private String newWarehouse;
    @Excel(name = "新库位",orderNum = "4")
    private String newLocation;
    @Excel(name = "说明",orderNum = "5")
    private String remark;
    @Excel(name = "操作人",  orderNum = "6")
    private String workName1;
    @Excel(name = "操作时间",  orderNum = "7")
    private String workDate1;
}
