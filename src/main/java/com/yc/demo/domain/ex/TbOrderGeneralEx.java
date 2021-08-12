package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbOrderGeneral;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/8/12 15:12
 */
@Getter
@Setter
public class TbOrderGeneralEx extends TbOrderGeneral {
    private List<String> groupUuidList;
}
