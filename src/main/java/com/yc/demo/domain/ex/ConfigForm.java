package com.yc.demo.domain.ex;

import com.yc.demo.domain.TbConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Yanchen
 * date 2021/4/15 20:17
 */
@Setter
@Getter
public class ConfigForm extends TbConfig {
    private String orderNo;
    private String productNo;
    private String serialNo;
}
