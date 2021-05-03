package com.yc.demo.domain.ex;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yanchen
 * date 2021/5/3 15:54
 */
@Setter
@Getter
public class CheckInfoExcel {
    @Excel(name = "工序", mergeVertical=true, orderNum = "0")
    private String num;

    @Excel(name = "装配内容", mergeVertical=true,orderNum = "1",width = 20.0)
    private String contentName;

    @Excel(name = "检测项目", orderNum = "2",width = 20.0)
    private String itemsName;

    @Excel(name = "结果", orderNum = "3")
    private String checkResultName;

    @Excel(name = "数值", orderNum = "4")
    private String checkValueName;

    @Excel(name = "操作人", orderNum = "5")
    private String workUser;

    @Excel(name = "操作时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "6")
    private Date workTime;

    @Excel(name = "备注", orderNum = "7")
    private String remark;
}
