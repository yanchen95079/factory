package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbCheckInfoDetail;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/5/3 15:16
 */
@Setter
@Getter
public class TbCheckInfoDetailEx extends TbCheckInfoDetail {
    private String checkValueName;
    private String checkResultName;
}
