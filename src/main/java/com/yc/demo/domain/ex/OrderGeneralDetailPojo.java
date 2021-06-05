package com.yc.demo.domain.ex;

import com.yc.demo.domain.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Yanchen
 * date 2021/6/5 15:17
 */
@Setter
@Getter
public class OrderGeneralDetailPojo {
    private List<TbOrderExchange> tbOrderExchanges;
    private List<TbOrderProductionSupple> tbOrderProductionSupples;
    private List<TbOrderShortage> tbOrderShortages;
    private List<TbOrderWarehouseLocationTransfer> tbOrderWarehouseLocationTransfers;
    private List<TbOrderWarehousing> tbOrderWarehousings;
    private List<TbStatusFlowRecord> lists;
}
