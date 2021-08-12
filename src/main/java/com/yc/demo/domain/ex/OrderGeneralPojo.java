package com.yc.demo.domain.ex;

import com.yc.demo.domain.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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
    private List<TbOrderWarehouseLocationTransferNcm> tbOrderWarehouseLocationTransferNcms;
    private List<TbOrderWarehousing> tbOrderWarehousings;
    private TbUserEx user;
    /**
     * 操作人操作  比如 XX签字
     */
    private String workContent;
    /**
     * 操作人操作 备注 比如 XX签字
     */
    private String workContentRemark;
    /**
     *一组单子的总价格,当前只有补货单用
     */
    private BigDecimal totalAllCost;
}