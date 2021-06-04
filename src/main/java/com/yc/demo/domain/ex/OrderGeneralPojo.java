package com.yc.demo.domain.ex;

import com.yc.demo.domain.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/4 15:30
 */
@Setter
@Getter
public class OrderGeneralPojo extends TbOrderGeneral {
    private List<TbOrderExchange> tbOrderExchanges;
    private List<TbOrderProductionSupple> tbOrderProductionSupples;
    private List<TbOrderShortage> tbOrderShortages;
    private List<TbOrderWarehouseLocationTransfer> tbOrderWarehouseLocationTransfers;
    private List<TbOrderWarehousing> tbOrderWarehousings;
    private TbUserEx user;
    /**
     * 操作人操作  比如 XX签字
     */
    private String workContent;
}