package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbOrderGeneral;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yanchen
 * date 2021/6/4 21:07
 */
@Setter
@Getter
public class TbOrderGeneralSelectPage extends TbOrderGeneral {
    private Integer offset;
    private Integer limit;
    private Date createTimeStart;
    private Date createTimeEnd;
    private TbUserEx user;
    private Boolean allDateFlag;
}
