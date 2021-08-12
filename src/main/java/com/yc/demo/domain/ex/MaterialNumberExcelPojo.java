package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/8/12 14:06
 */
@Getter
@Setter
public class MaterialNumberExcelPojo {
    @Excel(name = "料号")
    private String number;

    @Excel(name = "料号名称")
    private String name;

    @Excel(name = "标准成本")
    private String standardCost;
}
