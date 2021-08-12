package com.yc.demo.domain.ex;

import com.yc.demo.domain.ex.TbUserEx;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Yanchen
 * date 2021/8/12 15:05
 */
@Setter
@Getter
public class TbOrderGeneralExcelPojo {
    private Date createTimeStart;
    private Date createTimeEnd;
    private TbUserEx user;
    private Integer defType;
    private List<String> groupUuidList;
}
